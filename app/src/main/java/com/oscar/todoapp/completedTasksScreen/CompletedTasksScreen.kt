package com.oscar.todoapp.completedTasksScreen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oscar.todoapp.initialScreen.data.models.Task
import com.oscar.todoapp.initialScreen.ui.TaskComponent

@Composable
fun CompletedTasksScreen(modifier: Modifier, tasks: List<Task>) {

    var completedTasks: List<Task> = tasks.map {
        if (it.estado == true) it else null
    }.filterNotNull()

    println(completedTasks)

    Column {
        LazyColumn(modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(completedTasks) { task ->
                TaskCompleted(task);
            }
        }
    }


}