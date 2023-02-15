package com.example.newviewsforapp.row_column

import android.widget.RemoteViews.RemoteCollectionItems
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle

@Composable
fun NavigationDrawer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(64.dp), contentAlignment = Alignment.Center
    ) {
        Text(text = "Header", fontSize = 60.sp)

    }
}

    @Composable
    fun DrawerBody(
        items: List<MenuItem>,
        modifier: Modifier=Modifier,
    ){

    }
