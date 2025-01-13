package com.oscar.todoapp.addTask.data.network.models.response

import com.oscar.todoapp.addTask.data.network.models.AddTasksClient
import com.oscar.todoapp.addTask.data.network.models.request.AddTaskRequest
import com.oscar.todoapp.models.ErrorResponse
import com.oscar.todoapp.models.SuccessResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

class AddTaskService @Inject constructor(private val addTasksClient: AddTasksClient){


    suspend fun addTask(tarea: AddTaskRequest): AddTaskResponse{

        try{

            var response =  withContext(Dispatchers.IO){
                    addTasksClient.postTask(tarea);
            }

            if (response.isSuccessful){
                return AddTaskResponse.successResponse(SuccessResponse(response.message()));
            }else{
                return AddTaskResponse.error(ErrorResponse(response.message(), response.code()));
            }


        }catch (e: HttpException){
            print(e.message)
            return AddTaskResponse.error(ErrorResponse(e.message(), e.code()));
        }
    }


}