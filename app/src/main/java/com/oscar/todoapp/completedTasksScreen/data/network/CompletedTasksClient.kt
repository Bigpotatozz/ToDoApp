package com.oscar.todoapp.completedTasksScreen.data.network

import com.oscar.todoapp.initialScreen.data.models.Task
import retrofit2.Response
import retrofit2.http.GET



interface CompletedTasksClient {
    @GET("tarea/getCompleted")
    suspend fun getCompletedTasks(): Response<List<Task>>
}