package com.xco3.androidinicio.sintaxis

fun main() {
    trimestre(2)
}

fun whenExample(x: Int): String {
    val dia: String = when (x) {
        1 -> "Lunes"
        2 -> "Martes"
        3 -> "Miercoles"
        4 -> "Jueves"
        5 -> "Viernes"
        6 -> "Sabado"
        7 -> "Domingo"
        else -> "Invalido"
    }
    return (dia)
}

fun trimestre(x:Int) {
    return when(x){
        in 1..3 -> print("Primer trimestre")
        4, 5, 6 -> print("Segundo trimestre")
        7, 8, 9 -> print("Tercer trimestre")
        10, 11, 12 -> print("Primer trimestre")
        else -> print("Invalido")
    }
}

fun result(value:Any){
    when (value){
        is Int -> print(value + value)
        is String -> print(value)
        is Boolean -> if (value) print("Velda")
        is Double -> print (value * value)
    }
}