package com.example.bookapicalling.model

data class Book(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)