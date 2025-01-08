package com.oscar.todoapp.initialScreen.data

import com.oscar.todoapp.initialScreen.data.network.response.InitialScreenResponse
import com.oscar.todoapp.initialScreen.data.network.response.InitialScreenService
import javax.inject.Inject

class InitialScreenRepository @Inject constructor(private val initialScreenService: InitialScreenService) {

    suspend fun getTasks(): InitialScreenResponse {

        return initialScreenService.getTasks();
    }
}