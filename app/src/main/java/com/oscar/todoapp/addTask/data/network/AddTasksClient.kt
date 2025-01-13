package com.oscar.todoapp.addTask.data.network.models

import com.oscar.todoapp.addTask.data.network.models.request.AddTaskRequest
import com.oscar.todoapp.addTask.data.network.models.response.AddTaskResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AddTasksClient {


    @POST("tarea/addTask")
    suspend fun postTask(@Body tarea: AddTaskRequest): Response<AddTaskResponse>

}