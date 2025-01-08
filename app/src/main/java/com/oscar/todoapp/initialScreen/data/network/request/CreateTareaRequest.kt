package com.oscar.todoapp.initialScreen.data.network.request

import java.time.LocalDate

data class CreateTareaRequest( var nombre: String, var descripcion: String, var fecha: LocalDate, var estado: Boolean) {
}