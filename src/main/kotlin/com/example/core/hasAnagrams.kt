package com.example.core

fun symbol(word: String): List<Char> = word.toCharArray().map { it }.sorted()

fun hasAnagrams(words: List<String>): Boolean {
    val word = words.toMutableList()
    for (element in words) {
        word -= element
        if (word.any { symbol(it) == symbol(element) }) return true
        word += element
    }
    return false
}