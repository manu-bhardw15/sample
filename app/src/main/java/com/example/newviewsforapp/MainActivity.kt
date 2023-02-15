package com.example.newviewsforapp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextLayoutInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.newviewsforapp.ui.theme.NewViewsForAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewViewsForAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    RowItem("Android")
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RowItem(name: String) {
    val scaffoldState= rememberScaffoldState()
    val navController= rememberNavController()
    val snackBarCoroutineScope= rememberCoroutineScope()
    Scaffold(scaffoldState = scaffoldState) {
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

            var text by remember { mutableStateOf("Name") }
            OutlinedTextField(
                value = text,
                onValueChange = {text=it},
                placeholder = { Text("Enter Email")}
            )
            Spacer(modifier = Modifier.height(10.dp))
            circularProgressBar1()
            val context= LocalContext.current

            Button(onClick = { snackBarCoroutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Hi, I am in the Snackbar state")
            }}, modifier = Modifier
                .height(50.dp)
                .width(150.dp)
                .align(Alignment.CenterHorizontally)
                .background(Color.LightGray)) {
                Text(text = "Submit", style = TextStyle(color = Color.White), fontSize = 20.sp)
            }
            lazyColumnList()
        }
    }
}

@Composable
fun circularProgressBar1(){
    Box(modifier = Modifier
        .height(70.dp)
        .fillMaxWidth()
        .background(Color.Yellow)) {
        CircularProgressIndicator(
            modifier = Modifier.align(alignment = Alignment.Center)
        )
    }
}

@Composable
fun lazyColumnList(){
    LazyColumn{
        items(100)
        {
            Row(modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()) {
                Text(text = "Item $it", fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp))

                Spacer(modifier = Modifier.width(50.dp))

                Image(painter = painterResource(id = R.drawable.logo),
                    contentDescription = "text 1",
                    modifier = Modifier
                        .size(30.dp, 30.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

fun showToast(context: Context,message: String) {
    Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
}


