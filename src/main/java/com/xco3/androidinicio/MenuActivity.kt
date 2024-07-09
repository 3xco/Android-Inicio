package com.xco3.androidinicio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.xco3.androidinicio.allapp.ToDoActivity
import com.xco3.androidinicio.firstapp.FirstAppActivity
import com.xco3.androidinicio.firstapp.ResultActivity
import com.xco3.androidinicio.imc.ImcActivity
import com.xco3.androidinicio.searchapp.SearchListActivity
import com.xco3.androidinicio.settings.SettingsActivity

class MenuActivity : AppCompatActivity() {

    private lateinit var btn1: MaterialButton
    private lateinit var btn2: MaterialButton
    private lateinit var btn3: MaterialButton
    private lateinit var btn4: MaterialButton
    private lateinit var btn5: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        initComponents()
        btn1.setOnClickListener { navigateToFirstApp() }
        btn2.setOnClickListener { navigateToSecondApp() }
        btn3.setOnClickListener { navigateToThirdApp() }
        btn4.setOnClickListener { navigateToFourthApp() }
        btn5.setOnClickListener { navigateToFifthApp() }
    }
    private fun navigateToFirstApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToSecondApp(){
        val intent2 = Intent(this, ImcActivity::class.java)
        startActivity(intent2)
    }
    private fun navigateToThirdApp(){
        val intent3 = Intent(this, ToDoActivity::class.java)
        startActivity(intent3)
    }
    private fun navigateToFourthApp(){
        val intent4 = Intent(this, SearchListActivity::class.java)
        startActivity(intent4)
    }
    private fun navigateToFifthApp(){
        val intent5 = Intent(this, SettingsActivity::class.java)
        startActivity(intent5)
    }
    private fun initComponents(){
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
    }
}