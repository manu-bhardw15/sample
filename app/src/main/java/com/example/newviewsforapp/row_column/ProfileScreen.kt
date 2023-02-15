package com.example.newviewsforapp.row_column

import NavScreens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Home Screen",
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
        Row( modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                onClick = { navController.navigate(NavScreens.Detail.route) }
            ) {
                Text(
                    text = "Go to Details",
                    modifier = Modifier.padding(5.dp),
                    style = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
            }
        }
    }
    @Composable
    fun MyTopBar(){
        TopAppBar(
            title = { Text(text = "AppBar") },
            modifier = Modifier.background(Color.Red),
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Menu, contentDescription = "menu")
                }
            },
            actions = {
                IconButton(onClick = {

                }) {
                    Icon(Icons.Filled.Notifications, contentDescription = "noti")
                }
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Search, contentDescription = "search")
                }
            }
        )
    }
}