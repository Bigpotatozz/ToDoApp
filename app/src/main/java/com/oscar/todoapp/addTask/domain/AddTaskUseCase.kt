package com.oscar.todoapp.addTask.domain

import com.oscar.todoapp.addTask.data.network.models.AddTasksRepository
import com.oscar.todoapp.addTask.data.network.models.request.AddTaskRequest
import com.oscar.todoapp.addTask.data.network.models.response.AddTaskResponse
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(val addTasksRepository: AddTasksRepository) {

    suspend fun addTask(task: AddTaskRequest): AddTaskResponse{
        return addTasksRepository.addTask(task);
    }
}