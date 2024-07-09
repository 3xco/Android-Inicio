package com.xco3.androidinicio.exercises

fun main() {
    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { c -> (9.0/5.0) * c + 32 }
    printFinalTemperature(350.0, "Kelvin", "Celsius") { k -> k - 273.15 }
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { f -> (5.0/9.0) * (f - 32) + 273.15 }
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
