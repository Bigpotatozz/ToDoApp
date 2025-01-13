package com.oscar.todoapp.addTask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.oscar.todoapp.addTask.domain.AddTaskUseCase
import javax.inject.Inject

class AddTaskViewModel @Inject constructor(private val addTaskUseCase: AddTaskUseCase){


    private val _nombre = MutableLiveData<String>();
    var nombre: LiveData<String> = _nombre;

    private val _descripcion = MutableLiveData<String>();
    var descripcion: LiveData<String> = _descripcion;

    private val _fecha = MutableLiveData<String>();
    var fecha: LiveData<String> = _fecha;





}