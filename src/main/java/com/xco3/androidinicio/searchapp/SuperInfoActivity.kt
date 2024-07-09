package com.xco3.androidinicio.searchapp

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso
import com.xco3.androidinicio.R
import com.xco3.androidinicio.databinding.ActivitySuperInfoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class SuperInfoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding: ActivitySuperInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        val shId = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperHeroInformation(shId)
    }

    private fun getSuperHeroInformation(shId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val superherodetail =
                getRetroFit().create(ApiService::class.java).getSuperheroesInfo(shId)
            if (superherodetail.body() != null) {
                runOnUiThread {
                    createUI(superherodetail.body()!!)
                }
            } else {
                Log.i("xco", "mal")
            }
        }
    }

    private fun createUI(superhero: SuperHeroInfoResponse) {
        Picasso.get().load(superhero.image.url).into(binding.ivSuperHero)
        binding.tvsuperheroname.text = superhero.name
        prepareStats(superhero.powerstats)
        binding.tvSuperheroRealName.text = superhero.biography.fullName
        binding.tvPublisher.text = superhero.biography.publisher
        binding.tvFirstA.text = superhero.biography.firstAppearance
        binding.tvOcu.text = superhero.work.ocu
        binding.tvRelati.text = superhero.connections.relatives
        binding.tvGroup.text = superhero.connections.group
    }

    private fun prepareStats(powerstats: PowerStatsResponse){
        updateHeight(binding.viewCombat, powerstats.combat)
        updateHeight(binding.viewPower, powerstats.power)
        updateHeight(binding.viewSpeed, powerstats.speed)
        updateHeight(binding.viewStrength, powerstats.strength)
        updateHeight(binding.viewDurability, powerstats.durability)
        updateHeight(binding.viewIntelligence, powerstats.intelligence)
    }

    private fun updateHeight(view: View, stat: String){
        val params = view.layoutParams
        params.height = pixelToDp(stat.toFloat())
        view.layoutParams = params
    }

    private fun pixelToDp(px: Float): Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }

    private fun getRetroFit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}