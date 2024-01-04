package by.bsuir.zhenyabigel.pmislabs.sportify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import by.bsuir.zhenyabigel.pmislabs.sportify.screens.MainScreen
import by.bsuir.zhenyabigel.pmislabs.sportify.ui.theme.SportifyTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SportifyTheme {
                MainScreen()
            }
        }
    }
}