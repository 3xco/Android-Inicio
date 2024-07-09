package com.xco3.androidinicio.allapp

sealed class TaskCategory (var isSelected:Boolean = true) {
    object Personal: TaskCategory()
    object Business: TaskCategory()
    object Other: TaskCategory()
}