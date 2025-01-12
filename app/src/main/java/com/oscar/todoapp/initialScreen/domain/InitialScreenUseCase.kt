package com.oscar.todoapp.initialScreen.domain

import com.oscar.todoapp.initialScreen.data.InitialScreenRepository
import com.oscar.todoapp.initialScreen.data.network.request.CompleteTareaRequest
import com.oscar.todoapp.initialScreen.data.network.response.InitialScreenResponse
import javax.inject.Inject

class InitialScreenUseCase @Inject constructor(private val initialScreenRepository: InitialScreenRepository) {

    suspend fun invokeGetTasks(): InitialScreenResponse {

        return initialScreenRepository.getTasks();
    }

    suspend fun invokeCompletedTasks(): InitialScreenResponse{
        return initialScreenRepository.getCompletedTasks();
    }

    suspend fun invokeCompleteTask(id_tarea: Int, estado: Boolean): InitialScreenResponse{

        val bodyReq = CompleteTareaRequest(estado);
        
        return initialScreenRepository.completeTask(id_tarea, bodyReq);
    }
}