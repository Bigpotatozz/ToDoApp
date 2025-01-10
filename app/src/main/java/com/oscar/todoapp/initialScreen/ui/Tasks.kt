package com.oscar.todoapp.initialScreen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oscar.todoapp.initialScreen.data.models.Task


@Composable
fun TaskComponent(task: Task, onCheckedChange: (Boolean) -> Unit){

    var estadoTarea by rememberSaveable { mutableStateOf(task.estado)}

    Row (modifier = Modifier.fillMaxWidth().background(color = Color(0xFFEFF3EA), shape = RoundedCornerShape(10.dp)).padding(10.dp),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
        Column {
            Text(task.descripcion, fontFamily = FontFamily.SansSerif, fontSize = 20.sp)
            Text(task.fecha, fontSize = 15.sp)
        }

            Checkbox(checked = estadoTarea, onCheckedChange = {
                estadoTarea = !estadoTarea
                onCheckedChange(it)})

    }
}