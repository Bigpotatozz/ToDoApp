package com.oscar.todoapp.initialScreen.data.network

import com.oscar.todoapp.initialScreen.data.models.Task
import com.oscar.todoapp.initialScreen.data.network.request.CompleteTareaRequest
import com.oscar.todoapp.models.SuccessResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface InitialScreenClient {



    @GET("tarea/getPendientTasks")
    suspend fun getTasks(): Response<List<Task>>

    @PATCH("tarea/complete/{id}")
    suspend fun completeTask(@Path("id") id: Int, @Body estado: CompleteTareaRequest): Response<SuccessResponse>


}