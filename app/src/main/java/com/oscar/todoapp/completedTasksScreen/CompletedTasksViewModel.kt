package com.oscar.todoapp.completedTasksScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.oscar.todoapp.completedTasksScreen.data.network.response.CompletedTasksResponse
import com.oscar.todoapp.completedTasksScreen.domain.CompletedTasksUseCase
import com.oscar.todoapp.initialScreen.data.models.Task
import com.oscar.todoapp.initialScreen.data.network.response.InitialScreenResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CompletedTasksViewModel @Inject constructor(private val completedTasksUseCase: CompletedTasksUseCase): ViewModel() {


    private val _tasks = MutableLiveData<List<Task>>();
    var tasks: LiveData<List<Task>> = _tasks;




  fun getCompletedTasks(){

        viewModelScope.launch {
            var tareas = completedTasksUseCase.invokeCompletedTasks();

            when(tareas){
                is CompletedTasksResponse.error -> emptyList<Task>()
                is CompletedTasksResponse.successResponse -> emptyList<Task>()
                is CompletedTasksResponse.getTasksSuccess -> _tasks.value = tareas.tasks
            }
        }

    }


}