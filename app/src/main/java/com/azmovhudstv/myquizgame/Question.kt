package com.azmovhudstv.myquizgame

data class Question (
    val id: Int,
    val question: String,
    val variant1: String,
    val variant2: String,
    val variant3: String,
    val variant4: String,
    val togriJavob: Int
)