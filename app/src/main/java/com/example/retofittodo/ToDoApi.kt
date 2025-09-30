package com.example.retofittodo


import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ToDoApi {
    @GET("/todos")
    suspend fun getTodos(): Response<List<ToDoDTO>>
}