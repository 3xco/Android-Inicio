package com.xco3.androidinicio.searchapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.compose.ui.window.Dialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.xco3.androidinicio.R
import com.xco3.androidinicio.databinding.ActivitySearchListBinding
import com.xco3.androidinicio.searchapp.SuperInfoActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchListBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()

    }

    private fun initUI() {
        binding.svSearch.setOnQueryTextListener(/* listener = */ object :
            SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false

        })
        adapter = SuperHeroAdapter{ navigateToDetail(it)}
        binding.rvHentai.setHasFixedSize(true)
        binding.rvHentai.layoutManager = LinearLayoutManager(this)
        binding.rvHentai.adapter = adapter
    }

    private fun searchByName(query: String) {
        binding.pb.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = retrofit.create(ApiService::class.java).getSuperheroes(query)
            if(myResponse.isSuccessful){
                val response: SuperHeroDataResponse? = myResponse.body()
                if (response != null){
                    Log.i("xco", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.superH)
                        binding.pb.isVisible = false
                    }
                }
            }else{

            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun navigateToDetail(id:String){
        val intent=Intent(this, SuperInfoActivity::class.java)
        intent.putExtra(EXTRA_ID,id)
        startActivity(intent)
    }
}