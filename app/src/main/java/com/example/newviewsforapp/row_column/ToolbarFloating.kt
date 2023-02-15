package com.example.newviewsforapp.row_column
import Navigation
import android.annotation.SuppressLint

import android.os.Bundle
import android.widget.Toast

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newviewsforapp.Pager
import com.example.newviewsforapp.dataList
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield


class ToolbarFloating : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState: ScaffoldState = rememberScaffoldState()
//            val navController = rememberNavController()
//            Navigation(navController = navController)


           Scaffold(
               scaffoldState = scaffoldState,
               content = { MyTopBar() },
               floatingActionButton = {
                   FloatingActionButton(onClick = {  }) {
                    IconButton(onClick = {

                    }) {
                        Icon(Icons.Filled.Add, contentDescription = "")
                    }
                   }
               },
           )
            Greeting()
//            DialogBox()
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

    @Composable
    fun Greeting(){
        var isDialog by remember{ mutableStateOf(value = false) }
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(100.dp)) {
            Text(text = "Hello, Android",
            style = TextStyle(color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)
            )
            Button(onClick = {
                isDialog=true
            }) {
                Text(text = "Click here, dialog box will open", textAlign = TextAlign.Center)
            }
            if(isDialog)
                Dialog(onDismissRequest = {
                    isDialog=false
                }) {
                    CircularProgressIndicator()
                }
            LaunchedEffect(key1 = Unit, block = {
                try {
                    startTimer(3000L){
                        println("Timer Ended")
//                    Toast.makeText(this@ToolbarFloating,
//                        "Timer Ended",Toast.LENGTH_SHORT)
                    }
                }catch (ex:java.lang.Exception){
                    println("Timer Cancelled")
//                    Toast.makeText(this@ToolbarFloating,
//                        "Timer Cancelled",Toast.LENGTH_SHORT)
                }
            })
//            AlertDialogScreen()
            pager()

        }
    }

}
 suspend fun startTimer(time:Long, onTimeEnd: ()->Unit){
    delay(time)
    onTimeEnd()
}

@Composable
fun AlertDialogScreen(){
    var isDialog by remember{ mutableStateOf(value = false) }

    Column(modifier =Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {

        Button(onClick = { isDialog = true }, shape = RoundedCornerShape(10.dp)) {
            Text(text = "Click to Open alert box!")

        }
    }

        if (isDialog)
            AlertDialog(onDismissRequest = { isDialog=false },
                title = {Text(text = "Alert Dialog Box")},
                text = {Text(text = "Hi, I am in Alert dialog box")},
                modifier = Modifier.fillMaxWidth(),
                buttons = { Button(onClick = { isDialog=false },
                   modifier = Modifier
                       .padding(10.dp)
                       .padding(100.dp, 0.dp, 50.dp, 0.dp)
                ) {
                    Text(text = "Okay")

                }
                },
                backgroundColor = Color.LightGray
            )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun pager(){
    val pageState= rememberPagerState(
       initialPage = 0
    )

//    LaunchedEffect(key1 = Unit) {
//        while (true)
////            yield()
//        delay(2000)
//        pageState.animateScrollToPage(
//            page = (pageState.currentPage+1)%(pageState.pageCount),
//            animationSpec = tween(600)
//        )
//    }

    Column {
        HorizontalPager(count = dataList.size,
        state = pageState,
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
        )
        {
            page ->
                PageUi(pager = dataList[page])
        }
        HorizontalPagerIndicator(pagerState = pageState,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(20.dp),
       activeColor = Color.Red
        )
    }
}
@Composable
fun PageUi(pager: Pager){
    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painterResource(id =  pager.image), contentDescription =pager.des,
        modifier = Modifier.size(100.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = pager.des)
    }
}
