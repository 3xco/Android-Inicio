package com.xco3.androidinicio.sintaxis

fun main(){
    inte()
}

fun character(){
    for (x in 'a'..'z')
        println(x)
}

fun inte(){
    for (x in 3..10) {
        if (x == 5) {
            continue
        }
        println(x)
    }
}