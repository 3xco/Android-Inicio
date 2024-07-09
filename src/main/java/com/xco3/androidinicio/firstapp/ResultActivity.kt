package com.xco3.androidinicio.firstapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.xco3.androidinicio.R

class ResultActivity : AppCompatActivity() {

    private lateinit var textR: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        initComponent()
        val nameR: String = intent.extras?.getString("RESULTANTLY").orEmpty()
        initListeners(nameR)
    }
    private fun initComponent() {
        textR = findViewById(R.id.textR)
    }
    private fun initListeners(nameR: String) {
        textR.text = "Hola $nameR"
    }
}