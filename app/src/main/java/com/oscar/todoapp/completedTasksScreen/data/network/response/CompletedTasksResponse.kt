package com.oscar.todoapp.completedTasksScreen.data.network.response

import com.oscar.todoapp.initialScreen.data.models.Task
import com.oscar.todoapp.initialScreen.data.network.response.InitialScreenResponse
import com.oscar.todoapp.models.ErrorResponse
import com.oscar.todoapp.models.SuccessResponse

sealed class CompletedTasksResponse {

    data class getTasksSuccess(val tasks: List<Task>) : CompletedTasksResponse();
    data class successResponse(val successResponse: SuccessResponse) : CompletedTasksResponse();
    data class error(val errorResponse: ErrorResponse): CompletedTasksResponse();
}