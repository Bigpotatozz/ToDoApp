package com.oscar.todoapp.completedTasksScreen.data.network.response

import com.oscar.todoapp.completedTasksScreen.data.network.CompletedTasksClient
import com.oscar.todoapp.models.ErrorResponse
import com.oscar.todoapp.initialScreen.data.network.response.InitialScreenResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class CompletedTasksService @Inject constructor(private val completedTasksClient: CompletedTasksClient){

    suspend fun getCompletedTasks(): CompletedTasksResponse {
        try{

            var response = withContext(Dispatchers.IO){
                completedTasksClient.getCompletedTasks()
            }

            if(response.isSuccessful){
                return CompletedTasksResponse.getTasksSuccess(response.body() ?: emptyList());
            }else{
                return CompletedTasksResponse.error(ErrorResponse(response.message(), response.code()));
            }


        }catch (e: HttpException){
            println(e.message())
            return CompletedTasksResponse.error(ErrorResponse(e.message(), e.code()))
        }
    }
}