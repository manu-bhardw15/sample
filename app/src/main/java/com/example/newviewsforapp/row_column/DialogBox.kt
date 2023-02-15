package com.example.newviewsforapp.row_column

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DialogBox() {
    var isDialog by remember{ mutableStateOf(value = false) }
    Column(modifier = Modifier
        .height(100.dp)
        .width(200.dp)
        .background(color = Color.White),
         verticalArrangement = Arrangement.Center) {
        Button(onClick = {
            isDialog=true
        }) {
            Text(text = "Click here")
        }

        if(isDialog)
            Dialog(onDismissRequest = {
                isDialog=false
            }) {
                CircularProgressIndicator()
            }

    }
}