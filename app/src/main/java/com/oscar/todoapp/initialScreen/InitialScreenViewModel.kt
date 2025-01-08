package com.oscar.todoapp.initialScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.oscar.todoapp.initialScreen.domain.InitialScreenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InitialScreenViewModel @Inject constructor(private val initialScreenUseCase: InitialScreenUseCase) :
    ViewModel() {


    fun getTasks() {
        viewModelScope.launch {
            val tareas = initialScreenUseCase.invokeGetTasks();
            println(tareas)
        }
    }
}