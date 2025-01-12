package com.oscar.todoapp.completedTasksScreen.domain

import com.oscar.todoapp.completedTasksScreen.data.CompletedTasksRepository
import javax.inject.Inject


class CompletedTasksUseCase @Inject constructor(private val completedTasksRepository: CompletedTasksRepository){
}