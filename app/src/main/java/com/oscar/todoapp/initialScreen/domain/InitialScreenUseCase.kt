package com.oscar.todoapp.initialScreen.domain

import com.oscar.todoapp.initialScreen.data.InitialScreenRepository
import com.oscar.todoapp.initialScreen.data.network.response.InitialScreenResponse
import javax.inject.Inject

class InitialScreenUseCase @Inject constructor(private val initialScreenRepository: InitialScreenRepository) {

    suspend fun invokeGetTasks(): InitialScreenResponse {

        return initialScreenRepository.getTasks();
    }

}