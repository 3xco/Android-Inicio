package com.xco3.androidinicio.imc

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.xco3.androidinicio.R
import com.xco3.androidinicio.sintaxis.result

class ImcActivity : AppCompatActivity() {
    private var isMaleSet: Boolean = true
    private var isFemaleSet: Boolean = false
    private var currentWeight: Int = 50
    private var currentAge: Int = 20
    private var currentHeigth: Int = 0

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var txtheight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvWeight: TextView
    private lateinit var rsWeight: RangeSlider
    //private lateinit var btnSubWeight: FloatingActionButton
    //private lateinit var btnAddWeight: FloatingActionButton

    private lateinit var btnSubAge: FloatingActionButton
    private lateinit var btnAddAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCal: Button

    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)
        initComponent()
        initListeners()
        initUI()
    }

    private fun initComponent() {
        viewMale = findViewById(R.id.genH)
        viewFemale = findViewById(R.id.genM)
        txtheight = findViewById(R.id.txtHeight)
        rsHeight = findViewById(R.id.rsHeight)
        rsWeight = findViewById(R.id.rsWeight)
        tvWeight = findViewById(R.id.tvweight)
        btnSubAge = findViewById(R.id.btnSubAge)
        btnAddAge = findViewById(R.id.btnAddAge)
        tvAge = findViewById(R.id.tvage)
        btnCal = findViewById(R.id.btnCal)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun initListeners() {
        viewMale.setOnClickListener {
            setGenderColor()
            changeGender()
        }
        viewFemale.setOnClickListener {
            setGenderColor()
            changeGender()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeigth = df.format(value).toInt()
            txtheight.text = "$currentHeigth CM"
        }
        rsWeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentWeight = df.format(value).toInt()
            tvWeight.text = "$currentWeight KG"
        }
        btnAddAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnSubAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnCal.setOnClickListener {
            val imcResult = calculateIMC()
            navigateToResult(imcResult)
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun calculateIMC():Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeigth.toDouble() / 100 * currentHeigth.toDouble() / 100)
        val result = df.format(imc).toDouble()
        return result
    }
    private fun navigateToResult(result:Double){
        val intent = Intent(this, ImcRActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun setWeight() {
        val wE: String = currentWeight.toString()
        tvWeight.text = "$wE KG"
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun changeGender() {
        isMaleSet = !isMaleSet
        isFemaleSet = !isFemaleSet
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackGColoR(isMaleSet))
        viewFemale.setCardBackgroundColor(getBackGColoR(isFemaleSet))
    }

    private fun getBackGColoR(isSelectedComponent: Boolean): Int {
        val colReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colReference)
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }
}