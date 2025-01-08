package com.oscar.todoapp.initialScreen.data.network

import com.oscar.todoapp.initialScreen.data.models.Task
import com.oscar.todoapp.initialScreen.data.network.response.InitialScreenResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface InitialScreenClient {



    @GET("tarea/")
    suspend fun getTasks(): Response<List<Task>>


}