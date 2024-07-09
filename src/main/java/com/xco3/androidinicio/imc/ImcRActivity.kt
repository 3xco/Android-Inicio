package com.xco3.androidinicio.imc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.xco3.androidinicio.R
import com.xco3.androidinicio.imc.ImcActivity.Companion.IMC_KEY

class ImcRActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnReCal: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_ractivity)
        initComponent()
        val result: Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnReCal.setOnClickListener{ onBackPressed()}
    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when (result) {
            in 0.0..18.50 -> {
                tvResult.text = getString(R.string.imc1)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.imc1))
                tvDescription.text = getString(R.string.imc1d)
            }

            in 18.50..24.90 -> {
                tvResult.text = getString(R.string.imc2)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.imc2))
                tvDescription.text = getString(R.string.imc2d)
            }

            in 25.0..29.90 -> {
                tvResult.text = getString(R.string.imc3)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.imc3))
                tvDescription.text = getString(R.string.imc3d)
            }

            in 30.0..60.00 -> {
                tvResult.text = getString(R.string.imc4)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.imc4))
                tvDescription.text = getString(R.string.imc4d)
            }

            else -> {
                tvIMC.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }

    }

    private fun initComponent() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCal = findViewById(R.id.btnReCal)
    }
}