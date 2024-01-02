package com.example.incrementedandroidjourney

import retrofit2.Call
import retrofit2.http.GET

interface EndpointsInterface {

    @GET("todos")
    fun getAllTodos(): Call<List<TodoModel>>

}