package com.example.retofittodo

data class ToDoDTO(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)