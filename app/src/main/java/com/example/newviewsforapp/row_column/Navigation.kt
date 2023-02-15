import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


import com.example.newviewsforapp.row_column.DetailScreen
import com.example.newviewsforapp.row_column.ProfileScreen

@Composable
fun Navigation (navController: NavHostController){

NavHost(navController = navController, startDestination = NavScreens.Home.route){
    composable(route = NavScreens.Home.route){
        ProfileScreen(navController)
    }
    composable(route = NavScreens.Detail.route){
        DetailScreen(navController)
    }
}
}