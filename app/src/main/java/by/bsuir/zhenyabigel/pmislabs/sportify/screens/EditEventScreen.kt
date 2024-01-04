package by.bsuir.zhenyabigel.pmislabs.sportify.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import by.bsuir.zhenyabigel.pmislabs.sportify.R
import by.bsuir.zhenyabigel.pmislabs.sportify.ui.theme.fontFamily
import by.bsuir.zhenyabigel.pmislabs.sportify.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import java.util.UUID

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditEventScreen(id: String?, navController: NavController, coroutineScope: CoroutineScope
   ) {
    val homeViewModel: HomeViewModel = viewModel()
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()
    val items = uiState.events
    val uuid: UUID = UUID.fromString(id)
    val event = homeViewModel.findSportEventById(sportEvents = items, uuid = uuid)
    val message = remember { mutableStateOf("") }
    val backgroundImage = painterResource(id = R.drawable.sportbackround)
    val secPartOfBackgroundImage = painterResource(id = R.drawable.secondpartofsportbackround)
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    .background(color = Color.White)
                    .height(45.dp),
                title = {
                    Text(
                        "EDIT EVENT",
                        fontFamily = fontFamily,
                        fontSize = 27.sp,
                        color = Color.Black
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(route = "Home")
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }

            )
        },
        bottomBar = {},
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 45.dp, bottom = 40.dp)

            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                )
                {


                    Box(
                        modifier = Modifier
                            .clickable { navController.navigate("Home") }
                            .height(110.dp)
                            .padding(10.dp)
                            .fillMaxWidth()
                            .clip(
                                shape = RoundedCornerShape(10.dp)
                            ),
                    ) {
                        Column {
                            var name by remember { mutableStateOf("") }
                            if (event != null) {
                                name = event.name
                            }
                            Text(
                                "Name:",
                                fontFamily = fontFamily,
                                fontSize = 20.sp,
                                color = Color.Black,
                            )
                            TextField(
                                modifier = Modifier
                                    .fillMaxSize(),
                                value = name,
                                textStyle = TextStyle(fontSize = 17.sp, fontFamily = fontFamily),
                                onValueChange = { newText -> name = newText },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Person,
                                        contentDescription = "sad"
                                    )
                                },
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .height(110.dp)
                            .padding(10.dp)
                            .fillMaxWidth()
                            .clip(
                                shape = RoundedCornerShape(10.dp),
                            ),
                    ) {
                        Column {
                            var firstTeam by remember { mutableStateOf("") }
                            if (event != null) {
                                firstTeam = event.firstTeam
                            }
                            Text(
                                "First team name:",
                                fontFamily = fontFamily,
                                fontSize = 20.sp,
                                color = Color.Black,
                            )
                            TextField(
                                modifier = Modifier
                                    .fillMaxSize(),
                                value = firstTeam,
                                textStyle = TextStyle(fontSize = 17.sp, fontFamily = fontFamily),
                                onValueChange = { newText -> firstTeam },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Person,
                                        contentDescription = "sad"
                                    )
                                },
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .height(110.dp)
                            .padding(10.dp)
                            .fillMaxWidth()
                            .clip(
                                shape = RoundedCornerShape(10.dp),
                            ),
                    ) {
                        Column {
                            var secondTeam by remember { mutableStateOf("") }
                            if (event != null) {
                                secondTeam = event.secondTeam
                            }
                            Text(
                                "Second team name:",
                                fontFamily = fontFamily,
                                fontSize = 20.sp,
                                color = Color.Black,
                            )
                            TextField(
                                modifier = Modifier
                                    .fillMaxSize(),
                                value = secondTeam,
                                textStyle = TextStyle(fontSize = 17.sp, fontFamily = fontFamily),
                                onValueChange = { newText -> secondTeam },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Person,
                                        contentDescription = "sad"
                                    )
                                },
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .height(110.dp)
                            .padding(10.dp)
                            .fillMaxWidth()
                            .clip(
                                shape = RoundedCornerShape(10.dp),
                            ),
                    ) {
                        Column {
                            var firstTeam by remember {
                                mutableStateOf(
                                    event?.firstTeam
                                        ?: ""
                                )
                            }
                            if (event != null) {
                                firstTeam = event.firstTeam
                            }
                            var secondTeam by remember {
                                mutableStateOf(
                                    event?.secondTeam
                                        ?: ""
                                )
                            }
                            if (event != null) {
                                secondTeam = event.secondTeam
                            }
                            var winningTeam by remember {
                                mutableStateOf(
                                    event?.winningTeam
                                        ?: ""
                                )
                            }
                            if (event != null) {
                                winningTeam = event.winningTeam
                            }
                            Text(
                                "Winner team:",
                                fontFamily = fontFamily,
                                fontSize = 20.sp,
                                color = Color.Black,
                            )
                            Row {
                                val state = remember { mutableStateOf(true) }
                               Column {
                                   Row(Modifier.selectableGroup())
                                   {
                                       Text(
                                           "first ",
                                           fontFamily = fontFamily,
                                           fontSize = 20.sp,
                                           color = Color.Black,
                                       )
                                       Text(
                                           "second",
                                           fontFamily = fontFamily,
                                           fontSize = 20.sp,
                                           color = Color.Black,
                                       )
                                   }
                                   Row(Modifier.selectableGroup())
                                   {
                                       RadioButton(
                                           selected = state.value,
                                           onClick = { state.value = true }
                                       )
                                       RadioButton(
                                           selected = !state.value,
                                           onClick = { state.value = false }
                                       )
                                   }
                               }
                            }
                        }

                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 40.dp, end = 40.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .clickable { navController.navigate("Home") }
                            .height(65.dp)
                            .padding(bottom = 10.dp)
                            .width(160.dp)
                            .clip(
                                shape = RoundedCornerShape(
                                    topStart = 10.dp,
                                    topEnd = 10.dp,
                                    bottomEnd = 0.dp,
                                    bottomStart = 0.dp,
                                ),
                            )
                            .background(color = Color.Black),

                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = secPartOfBackgroundImage,
                            contentDescription = "contentDescription",
                            contentScale = ContentScale.FillBounds
                        )
                        Text(
                            "SAVE",
                            fontFamily = fontFamily,
                            fontSize = 20.sp,
                            color = Color.White,
                        )

                    }
                    Box(
                        modifier = Modifier
                            .clickable { navController.navigate("Home") }
                            .height(65.dp)
                            .padding(bottom = 10.dp)
                            .width(160.dp)
                            .clip(
                                shape = RoundedCornerShape(
                                    topStart = 10.dp,
                                    topEnd = 10.dp,
                                    bottomEnd = 0.dp,
                                    bottomStart = 0.dp,
                                ),
                            )
                            .background(color = Color.Black),

                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = secPartOfBackgroundImage,
                            contentDescription = "contentDescription",
                            contentScale = ContentScale.FillBounds
                        )
                        Text(
                            "DELETE",
                            fontFamily = fontFamily,
                            fontSize = 20.sp,
                            color = Color.White,
                        )

                    }
                }
            }
        }
    )
}