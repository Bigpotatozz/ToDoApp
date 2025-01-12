package com.oscar.todoapp.initialScreen.data.network.response

import com.oscar.todoapp.initialScreen.data.network.InitialScreenClient
import com.oscar.todoapp.initialScreen.data.network.request.CompleteTareaRequest
import com.oscar.todoapp.models.ErrorResponse
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
            } else {
                print(response.body())
                return InitialScreenResponse.error(
                    ErrorResponse(
                        response.message(),
                        response.code()
                    )
                )
            }

        } catch (e: HttpException) {
            print(e);
            return InitialScreenResponse.error(ErrorResponse(e.message(), e.code()))
        }
    }



    suspend fun completeTask(id_tarea: Int, estado: CompleteTareaRequest): InitialScreenResponse {

        try {

            var response = withContext(Dispatchers.IO) {
                initialScreenClient.completeTask(id_tarea, estado);
            }

            if (response.isSuccessful) {
                return InitialScreenResponse.successResponse(response.body()!!)
            } else {
                print(response.body())
                return InitialScreenResponse.error(
                    ErrorResponse(
                        response.message(),
                        response.code()
                    )
                )
            }
        } catch (e: HttpException) {
            print(e.message());
            return InitialScreenResponse.error(ErrorResponse(e.message(), e.code()));
        }

    }

}