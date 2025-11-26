package com.example.testkotlin

data class Question(
//    val id: Int,
//    val question: String,
//    val option1: String,
//    val option2: String,
//    val option3: String,
//    val answer: String? // 1, 2 или 3
    val text: String,
    val options: List<String>,
    val scores: List<Int>  // баллы за каждый вариант
)
