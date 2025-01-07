package com.oscar.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oscar.todoapp.completedTasksScreen.ui.CompletedTasksScreen
import com.oscar.todoapp.initialScreen.data.models.Task
import com.oscar.todoapp.initialScreen.ui.InitialScreen
import com.oscar.todoapp.models.Routes
import com.oscar.todoapp.ui.theme.ToDoAppTheme
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoAppTheme {
                val navigation = rememberNavController();
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(navController = navigation) }) { innerPadding ->

                    val tasks = listOf(
                        Task("Hacer la tarea", LocalDate.of(2025, 1, 6), false),
                        Task("Hacer la tarea2", LocalDate.of(2025, 1, 6), false),
                        Task("Hacer la tarea3", LocalDate.of(2025, 1, 6), false),
                        Task("Hacer la tarea4", LocalDate.of(2025, 1, 6), false),
                        Task("Hacer la tarea5", LocalDate.of(2025, 1, 6), false),
                        Task("Hacer la tarea6", LocalDate.of(2025, 1, 6), false),
                        Task("Hacer la tarea7", LocalDate.of(2025, 1, 6), false),
                        Task("Hacer la tarea8", LocalDate.of(2025, 1, 6), false),
                        Task("Hacer la tarea9", LocalDate.of(2025, 1, 6), false),
                        Task("Hacer la tarea10", LocalDate.of(2025, 1, 6), false),
                        Task("Hacer la tarea11", LocalDate.of(2025, 1, 6), false),
                        Task("Hacer la tarea12", LocalDate.of(2025, 1, 6), false),
                        Task("Hacer la tarea13", LocalDate.of(2025, 1, 6), false),
                        Task("Hacer la tarea14", LocalDate.of(2025, 1, 6), false),
                        Task("Hacer la tarea15", LocalDate.of(2025, 1, 6), false),
                        Task("Hacer la tarea16", LocalDate.of(2025, 1, 6), false),
                        Task("Hacer la tarea17", LocalDate.of(2025, 1, 6), false),
                    );


                    NavHost(navController = navigation, startDestination = Routes.InitialScreen.route){
                        composable(Routes.InitialScreen.route){ InitialScreen(modifier = Modifier.padding(innerPadding),
                            tasks = tasks,
                            navController = navigation) }

                        composable(Routes.CompletedTasksScreen.route){
                            CompletedTasksScreen(modifier = Modifier.padding(innerPadding), tasks)
                        }
                    }

                }
            }
        }
    }
}


@Composable
fun BottomNavigationBar(navController: NavController) {
    var index by rememberSaveable { mutableStateOf(0) }

    NavigationBar() {

        NavigationBarItem(icon = {
            Icon(imageVector = Icons.Filled.Home, contentDescription = "Home")
        }, label = { Text("Home") },
            onClick = { index = 0
                      navController.navigate(Routes.InitialScreen.route)
                      },
            selected = index == 0
        )

        NavigationBarItem(icon = {
            Icon(imageVector = Icons.Filled.Check, contentDescription = "Completed")
        }, label = { Text("Completed") },
            onClick = { index = 1
                      navController.navigate(Routes.CompletedTasksScreen.route)
                      },
            selected = index == 1

        )
    }
}