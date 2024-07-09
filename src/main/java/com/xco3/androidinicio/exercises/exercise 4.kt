package com.xco3.androidinicio.exercises

class Song(
    val title: String,
    val artist: String,
    val releaseYear: Int,
    val playCount: Int
) {
    val isPopular: String = if (playCount >= 1000){
        "Si"
    }else{
        "No"
    }
    fun printDescription() {
        println("$title, interpretada por $artist, se lanzó en $releaseYear.")
    }
}

fun main() {
    val song = Song("Despacito", "Luis Fonsi", 2017, 2000)
    song.printDescription()
    println("Es popular: ${song.isPopular}")
}
