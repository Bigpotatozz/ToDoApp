package com.oscar.todoapp.initialScreen.data.network

import com.oscar.todoapp.initialScreen.data.models.Task
import com.oscar.todoapp.initialScreen.data.network.response.InitialScreenResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface InitialScreenClient {



    @GET("tarea/getTasks")
    suspend fun getTasks(): Response<List<Task>>

    @PATCH("tarea/complete/")
    suspend fun completeTask(@Query("id") idTask: Int): Response<String>


}