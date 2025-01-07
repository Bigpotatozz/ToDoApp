package com.oscar.todoapp.initialScreen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.oscar.todoapp.initialScreen.data.models.Task
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date


@Composable
fun InitialScreen(modifier: Modifier, tasks: List<Task>, navController: NavController){

    Column {
        LazyColumn(modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(tasks){
                task ->
                TaskComponent(task) {
                    task.estado = it
                    println(task)
                }
            }
        }
    }



}



