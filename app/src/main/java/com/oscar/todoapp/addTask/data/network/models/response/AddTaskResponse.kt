package com.oscar.todoapp.addTask.data.network.models.response

import com.oscar.todoapp.completedTasksScreen.data.network.response.CompletedTasksResponse
import com.oscar.todoapp.models.ErrorResponse
import com.oscar.todoapp.models.SuccessResponse

sealed class AddTaskResponse {

    data class successResponse(val successResponse: SuccessResponse) : AddTaskResponse();
    data class error(val errorResponse: ErrorResponse): AddTaskResponse();

}