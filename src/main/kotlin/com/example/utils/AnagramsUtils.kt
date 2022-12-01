package com.example.utils

fun List<String>.isValidated(): Boolean {
    this.forEach { word->
        if (word.isBlank() || word.contains(" ")) return false
    }
    return true
}