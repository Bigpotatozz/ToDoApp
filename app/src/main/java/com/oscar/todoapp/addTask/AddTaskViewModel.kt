package com.oscar.todoapp.addTask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.oscar.todoapp.addTask.data.network.models.request.AddTaskRequest
import com.oscar.todoapp.addTask.data.network.models.response.AddTaskResponse
import com.oscar.todoapp.addTask.domain.AddTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class AddTaskViewModel @Inject constructor(private val addTaskUseCase: AddTaskUseCase): ViewModel(){


    private val _nombre = MutableLiveData<String>("");
    var nombre: LiveData<String> = _nombre;

    private val _descripcion = MutableLiveData<String>("");
    var descripcion: LiveData<String> = _descripcion;

    private val _fecha = MutableLiveData<String>("");
    var fecha: LiveData<String> = _fecha;


    fun changeNombre(nombre: String){
        _nombre.value = nombre;
    }

    fun changeDescripcion(descripcion: String){
        _descripcion.value = descripcion;
    }

    fun changeFecha(fecha: String){
        _fecha.value = fecha;
    }


    fun addTask(nombre: String, descripcion: String){


        val tarea = AddTaskRequest(nombre, descripcion, "${LocalDate.now()}")

        changeFecha("${LocalDate.now()}");

        viewModelScope.launch {
            val response = addTaskUseCase.invokeAddTask(tarea);

            print(response);
        }

    }





}