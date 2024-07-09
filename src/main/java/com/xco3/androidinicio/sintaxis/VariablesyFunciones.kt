package com.xco3.androidinicio.sintaxis

//todo lo que esta fuera de las funciones quedan siendo globales

fun main() {
    showMyName(name = "Michael")
    showMyAge()
    //var y:Int = su(x=8,y=9)
    print (su(8,9) + add(8, 9) + su2(8, 9))

}

fun showMyName(name:String) {
    println("Mi nombre es $name")
}

fun showMyAge(currentAge: Int = 24) {
    println("Mi edad es $currentAge")
}

fun add (x:Int, y:Int):Int{
    return (x + y)
}
fun su(x:Int, y:Int):Int{
    return x - y
}
fun su2(x:Int, y:Int):Int =x - y

fun vaariablesNumericas() {
    //Int -2147.4483.647 a 2147.483.647
    var age: Int = 30
    val age1 = 30
    age = 25

    //Long Numeros grandes
    val example: Long = 30

    //Float Numeros decimales hasta 6
    val floatExample: Float = 30.543215f
    val floatExample1: Float
    floatExample1 = 30.543f

    //Double Numeros decimales hasta 14
    val doubleExample: Double = 30.556155132132133

    //Operaciones aritmeticas
    var x = 1;
    var y = 2
    x = 2
    y = 6

    x + y
    x - y
    x * y
    x / y
    x % y //Modulo
}

fun variablesAlfanumericas() {
    //Variable alfanumericas:

    //Char un solo caracter
    val charExample1: Char = 'a'

    //String
    val strinExample: String = "Hola"

    //con el + se concatenan
}

fun booleans() {
    //Booleans

    //Boolean
    val booleanExample: Boolean = false
    val booleanExample1: Boolean = true
}