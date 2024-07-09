package com.xco3.androidinicio.sintaxis

fun main(){
    listaMutable()
}

fun listaInmutable(){
    val readOnly:List<String> = listOf("Lunes",
        "Martes",
        "Miercoles",
        "Jueves",
        "Viernes",
        "Sabado",
        "Domingo")
    //println(readOnly)
    //println(readOnly[1])
    //println(readOnly.last())
    //println(readOnly.first())

    //Filtrar
    //val x = readOnly.filter { it.contains("a") }
    //println(x)
    readOnly.forEach{weekDay -> println(weekDay)}
}

fun listaMutable(){
    var weekDays:MutableList<String> = mutableListOf("Lunes",
        "Martes",
        "Miercoles",
        "Jueves",
        "Viernes",
        "Sabado",
        "Domingo")
    weekDays.add(0, "Adultos")
    println(weekDays.last())

    weekDays.forEach { println(it) }

}