package com.oscar.todoapp.completedTasksScreen.domain

import com.oscar.todoapp.completedTasksScreen.data.CompletedTasksRepository
import com.oscar.todoapp.completedTasksScreen.data.network.response.CompletedTasksResponse
import javax.inject.Inject


class CompletedTasksUseCase @Inject constructor(private val completedTasksRepository: CompletedTasksRepository){


    suspend fun invokeCompletedTasks(): CompletedTasksResponse{
        return completedTasksRepository.getCompletedTasks();
    }

}