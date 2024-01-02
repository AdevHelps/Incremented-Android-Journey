package com.example.incrementedandroidjourney

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {

    private const val baseURL = "https://jsonplaceholder.typicode.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseURL)
        .build()

    val EndpointsInterfaceImpl: EndpointsInterface = retrofit.create(EndpointsInterface::class.java)

}