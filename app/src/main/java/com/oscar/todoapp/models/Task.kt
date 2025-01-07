package com.oscar.todoapp.initialScreen.data.models

import java.time.LocalDate
import java.util.Date

data class Task(var nombre: String, var descripcion: String, var fecha: LocalDate, var estado: Boolean) {
}