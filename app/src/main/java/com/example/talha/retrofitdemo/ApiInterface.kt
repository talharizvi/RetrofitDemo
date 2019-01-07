package com.example.talha.retrofitdemo


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST



interface ApiInterface {
@GET("api/unknown")
fun doGetListResources(): Call<MultipleResource>

    @POST("/api/users")
    fun createUser(@Body user: User): Call<User>
}