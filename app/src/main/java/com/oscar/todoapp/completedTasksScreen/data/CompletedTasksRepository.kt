package com.oscar.todoapp.completedTasksScreen.data

import com.oscar.todoapp.completedTasksScreen.data.network.response.CompletedTasksResponse
import com.oscar.todoapp.completedTasksScreen.data.network.response.CompletedTasksService
import javax.inject.Inject

class CompletedTasksRepository @Inject constructor(private val completedTasksService: CompletedTasksService){

    suspend fun getCompletedTasks(): CompletedTasksResponse{
        return completedTasksService.getCompletedTasks();
    }
}