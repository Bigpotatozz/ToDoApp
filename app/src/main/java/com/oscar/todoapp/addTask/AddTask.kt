package com.oscar.todoapp.addTask

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Composable
fun DialogAgregarTarea(addTaskViewModel: AddTaskViewModel){

    var dialogVisible by remember { mutableStateOf(false) }

    val nombre: String by addTaskViewModel.nombre.observeAsState("");
    val descripcion: String by addTaskViewModel.descripcion.observeAsState("");


    FloatingActionButton(onClick = {
        dialogVisible = true;
    }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Agregar tarea"
        );
    }

    if(dialogVisible){
        Dialog(onDismissRequest = {dialogVisible = false },
            properties = DialogProperties(dismissOnClickOutside = true, dismissOnBackPress = true)) {


            FormularioAgregarTarea(addTaskViewModel) {
                addTaskViewModel.addTask(nombre, descripcion);

            }
        }
    }

}


@Composable
fun FormularioAgregarTarea(addTaskViewModel: AddTaskViewModel, onClick:()-> Unit){

    Box(Modifier.clip(RoundedCornerShape(15.dp)).background(Color.White).padding(15.dp)){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(modifier = Modifier.padding(top = 15.dp),
                value = addTaskViewModel.nombre.value!!,
                onValueChange = {addTaskViewModel.changeNombre(it)},
                label = { Text("Nombre") } )
            OutlinedTextField(modifier = Modifier.padding(top = 15.dp),
                value = addTaskViewModel.descripcion.value!!,
                onValueChange = {addTaskViewModel.changeDescripcion(it)},
                label = { Text("Descripcion") } )
            Button(modifier = Modifier.padding(top = 15.dp),
                onClick = { onClick() }) {
                Text("Guardar tarea")
            }

        }
    }

}
