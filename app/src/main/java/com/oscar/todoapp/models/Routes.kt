package com.oscar.todoapp.models

sealed class Routes(val route: String) {

    object InitialScreen: Routes("initialScreen");
    object CompletedTasksScreen: Routes("completedTasksScreen");


}