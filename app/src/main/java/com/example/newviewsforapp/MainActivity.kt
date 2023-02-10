package com.example.newviewsforapp

import android.os.Bundle
import android.text.InputType
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextLayoutInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newviewsforapp.ui.theme.NewViewsForAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewViewsForAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RowItem("Android")
                }
            }
        }
    }
}

@Composable
fun RowItem(name: String) {
    Column {
        Row(modifier =Modifier.background(Color.Cyan), verticalAlignment = Alignment.Top) {
            Column(modifier =Modifier.background(Color.LightGray)) {
                Text(text = "Text 1", modifier = Modifier.padding(10.dp), color = Color.Blue,
                    fontStyle = FontStyle.Italic, fontSize = 20.sp, overflow = TextOverflow.Clip)
                Text(text = "Text 2", modifier = Modifier.padding(10.dp), color = Color.Red)
                Text(text = "Text 3", modifier = Modifier.padding(10.dp), color = Color.Magenta)
            }
            Column(modifier =Modifier.background(Color.White)) {
                Text(text = "Text 4", modifier = Modifier.padding(10.dp), color = Color.Blue,
                    fontStyle = FontStyle.Italic, fontSize = 20.sp, overflow = TextOverflow.Clip)
                Text(text = "Text 5", modifier = Modifier.padding(10.dp), color = Color.Red)
                Text(text = "Text 6", modifier = Modifier.padding(10.dp), color = Color.Magenta)
            }
            Text(text = "New Text", style = TextStyle(color = Color.Blue, fontSize = 20.sp, fontStyle = FontStyle.Normal ))
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(modifier = Modifier
            .size(200.dp, 200.dp)
            .background(Color.DarkGray)
            .clip(RoundedCornerShape(10.dp))) {
          Column(modifier = Modifier.align(alignment = Alignment.Center)) {
              Image(
                  painter = painterResource(id = R.drawable.logo), contentDescription = "Image",
                  contentScale = ContentScale.Crop, modifier = Modifier
                      .clip(RoundedCornerShape(10.dp))
                      .width(100.dp)
                      .height(100.dp)
              )

              Text(text = "Image one", style = TextStyle(color = Color.White, fontSize = 15.sp),)
          }
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = "text",
            onValueChange = {it},
            label = { Text("UserName") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = "Name",
            onValueChange = {it},
            label = { Text("UserName") }
        )

    }
}


