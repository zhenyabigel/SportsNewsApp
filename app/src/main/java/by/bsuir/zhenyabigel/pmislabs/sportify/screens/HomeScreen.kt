package by.bsuir.zhenyabigel.pmislabs.sportify.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import by.bsuir.zhenyabigel.pmislabs.sportify.R
import by.bsuir.zhenyabigel.pmislabs.sportify.navigation.BottomBarScreen
import by.bsuir.zhenyabigel.pmislabs.sportify.ui.theme.fontFamily
import by.bsuir.zhenyabigel.pmislabs.sportify.viewmodel.HomeViewModel



@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){

    val viewModel = viewModel<HomeViewModel>()
    val secPartOfBackgroundImage = painterResource(id = R.drawable.backround3)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val items = uiState.events
    Scaffold(
        backgroundColor = Color.Black,
        topBar = {
            TopAppBar (
                backgroundColor = Color.White,
                modifier = Modifier.height(45.dp),
                title = {
                    Row(verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxHeight()) {
                        Text("SPORTS EVENTS",
                            fontFamily = fontFamily,
                            fontSize = 27.sp,
                            color = Color.Black)
                        Text("Watch sports events with us",
                            fontFamily = fontFamily,
                            fontSize = 10.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(start = 10.dp, bottom = 5.dp))
                    }

                },
                actions = {
                    IconButton(onClick = {navController.navigate("Home") }) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Localized description"
                        )
                    }
                }

            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
            ){
                Image(
                    painter = secPartOfBackgroundImage,
                    contentDescription = "contentDescription",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
                LazyColumn(
                    modifier = Modifier.padding(top=7.dp),
                    contentPadding = PaddingValues(all = 5.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(items = items) { item ->
                        CustomItem(false,
                            sportEvent = item,
                            onClickRemove  = {
                                viewModel.deleteEvent(it)
                            },
                            onClickAddToFavorite = {
                                viewModel.addEventToFavorite(item)
                                                   },
                            onClickEdit = {
                                navController.navigate(BottomBarScreen.EditScreen.withArgs(item.id.toString()))
                            }
                        )
                    }
                }

            }


        }

    )
}