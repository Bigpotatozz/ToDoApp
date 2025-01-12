package com.oscar.todoapp.initialScreen.data

import com.oscar.todoapp.initialScreen.data.network.request.CompleteTareaRequest
import com.oscar.todoapp.initialScreen.data.network.response.InitialScreenResponse
import com.oscar.todoapp.initialScreen.data.network.response.InitialScreenService
import javax.inject.Inject

class InitialScreenRepository @Inject constructor(private val initialScreenService: InitialScreenService) {

    suspend fun getTasks(): InitialScreenResponse {

        return initialScreenService.getTasks();
    }

    suspend fun getCompletedTasks(): InitialScreenResponse{
        return initialScreenService.getCompletedTasks();
    }

    suspend fun completeTask(id_tarea: Int, estatus: CompleteTareaRequest): InitialScreenResponse {
        return initialScreenService.completeTask(id_tarea, estatus);
    }
}