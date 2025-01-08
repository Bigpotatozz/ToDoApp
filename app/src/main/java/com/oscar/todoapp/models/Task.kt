package com.oscar.todoapp.initialScreen.data.models

import java.time.LocalDate
import java.util.Date

data class Task(var id_task: Int, var nombre: String, var descripcion: String, var fecha: String, var estado: Boolean) {
}