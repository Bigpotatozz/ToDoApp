package com.oscar.todoapp.initialScreen.data.network.response

import com.oscar.todoapp.initialScreen.data.models.Task
import com.oscar.todoapp.initialScreen.data.network.InitialScreenClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class InitialScreenService @Inject constructor(private val initialScreenClient: InitialScreenClient) {


    suspend fun getTasks(): InitialScreenResponse {

        try {

            var response = withContext(Dispatchers.IO) {
                initialScreenClient.getTasks();
            }

            if (response.isSuccessful) {
                return InitialScreenResponse.getTasksSuccess(response.body() ?: emptyList())
            }else{
                print(response.body())
                return InitialScreenResponse.error(ErrorResponse(response.message(), response.code()))
            }

        } catch (e: HttpException) {
            print(e);
            return InitialScreenResponse.error(ErrorResponse(e.message(), e.code()))
        }
    }

}