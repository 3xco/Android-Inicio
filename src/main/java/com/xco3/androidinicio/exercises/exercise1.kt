package com.xco3.androidinicio.exercises

fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages <= 99){
        println("You have $numberOfMessages notifications.")
    }else{
        println("Your phone is blowing up! You have 99+ notifications.")
    }
}
