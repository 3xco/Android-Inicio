package com.xco3.androidinicio.firstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.xco3.androidinicio.R

class FirstAppActivity : AppCompatActivity() {

    private lateinit var name: TextView
    private lateinit var btnctmr: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_app)
        initComponents()
        initListeners()
    }

    private fun initComponents() {
        name = findViewById(R.id.tet)
        btnctmr = findViewById(R.id.btmctmr)
    }

    private fun initListeners() {
        btnctmr.setOnClickListener {
            val namem: String = name.text.toString()
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULTANTLY", namem)
            startActivity(intent)
        }
    }
}
