package com.oscar.todoapp.initialScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.oscar.todoapp.initialScreen.data.models.Task
import com.oscar.todoapp.initialScreen.data.network.response.InitialScreenResponse
import com.oscar.todoapp.initialScreen.domain.InitialScreenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InitialScreenViewModel @Inject constructor(private val initialScreenUseCase: InitialScreenUseCase) :
    ViewModel() {


    private var _tasks = MutableLiveData<List<Task>>();
    var tasks: LiveData<List<Task>> = _tasks;
        init {
            getTasks();
            println(tasks)
        }





    fun getTasks() {
        viewModelScope.launch {
            var tareas = initialScreenUseCase.invokeGetTasks();

            when(tareas){
                is InitialScreenResponse.error -> emptyList<Task>()
                is InitialScreenResponse.successResponse -> emptyList<Task>()
                is InitialScreenResponse.getTasksSuccess -> _tasks.value = tareas.tasks
            }

        }
    }

    fun completeTask(id_tarea: Int, estatus: Boolean){
        viewModelScope.launch {
            var completedTask = initialScreenUseCase.invokeCompleteTask(id_tarea, estatus);
            println(completedTask);
        }

    }
}