package com.oscar.todoapp.initialScreen.data.network.response

import com.oscar.todoapp.initialScreen.data.models.Task

sealed class InitialScreenResponse {

    data class getTasksSuccess(val tasks: List<Task>) : InitialScreenResponse();
    data class successResponse(val successResponse: SuccessResponse) : InitialScreenResponse();
    data class error(val errorResponse: ErrorResponse): InitialScreenResponse();


}