package com.xco3.androidinicio.sintaxis

fun main(){
    println (ifBa("Hola"))
    if (ifBa("Hola") == true){
        println(false)
    }else{
        println(true)
    }
}

fun ifBa(x:String):Boolean{
    val y:Boolean
    if (x.lowercase() == "hola"){
        y = true
    }
    else{
        y = false
    }
    return (y)
}