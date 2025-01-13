package com.oscar.todoapp.addTask.data.network.models

import com.oscar.todoapp.addTask.data.network.models.request.AddTaskRequest
import com.oscar.todoapp.addTask.data.network.models.response.AddTaskResponse
import com.oscar.todoapp.addTask.data.network.models.response.AddTaskService
import javax.inject.Inject

class AddTasksRepository @Inject constructor(private val addTaskService: AddTaskService){

    suspend fun addTask(task: AddTaskRequest): AddTaskResponse{

        return addTaskService.addTask(task);

    }

}