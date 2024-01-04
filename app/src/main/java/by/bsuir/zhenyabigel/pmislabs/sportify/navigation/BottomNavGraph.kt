package by.bsuir.zhenyabigel.pmislabs.sportify.navigation


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import by.bsuir.zhenyabigel.pmislabs.sportify.screens.*
import kotlinx.coroutines.CoroutineScope


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BottomNavGraph(navController: NavHostController, coroutineScope: CoroutineScope) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Favorite.route) {
            FavoriteScreen()
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen()
        }
        composable(route = BottomBarScreen.Search.route) {
            SearchScreen()
        }
        composable(route = BottomBarScreen.About.route) {
            AboutScreen(navController)
        }
        composable(     route = BottomBarScreen.EditScreen.route + "/{name}", arguments = listOf(
            navArgument("name") {
                type = NavType.StringType
                defaultValue = "-1"
                nullable = true
            })
        ) { entry ->
            EditEventScreen(id = entry.arguments?.getString("name"), navController = navController,  coroutineScope = coroutineScope)
        }
    }
}
sealed class Nav(
    val route: String,
    val title: String)
{
    object Edit:Nav (
        route = "Edit",
        title = "Edit"
    )
}
