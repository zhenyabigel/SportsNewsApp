package by.bsuir.zhenyabigel.pmislabs.sportify.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import by.bsuir.zhenyabigel.pmislabs.sportify.R
import by.bsuir.zhenyabigel.pmislabs.sportify.navigation.BottomBarScreen
import by.bsuir.zhenyabigel.pmislabs.sportify.ui.theme.fontFamily

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AboutScreen(navController:NavController){
    val backgroundImage = painterResource(id = R.drawable.sportbackround)
    val secPartOfBackgroundImage = painterResource(id = R.drawable.secondpartofsportbackround)
    val telegramIcon = painterResource(id = R.drawable.ic_tg)
    val instagramIcon = painterResource(id = R.drawable.ic_inst)
    val vkIcon = painterResource(id = R.drawable.ic_vk)
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar (
                modifier = Modifier
                    .background(color = Color.White)
                    .height(45.dp)
                ,
                title = {
                    Text( stringResource(id = R.string.about_us_title),
                        fontFamily = fontFamily,
                        fontSize = 27.sp,
                        color = Color.Black)
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "ArrowBack"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                }

            )
        },
        content = {
            Column (
                modifier = Modifier
                    .fillMaxSize()
            ){
                Box(
                    modifier = Modifier
                        .height(270.dp)
                        .fillMaxWidth()
                        .clip(
                            shape = RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomEnd = 15.dp,
                                bottomStart = 15.dp,
                            ),
                        )
                        .background(color = Color.Black),
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        painter = backgroundImage,
                        contentDescription = "backgroundAboutUs",
                        contentScale = ContentScale.FillBounds
                    )
                    Column (){
                        Text(
                            stringResource(id = R.string.app_name_uppercase),
                            fontFamily = fontFamily,
                            fontSize = 70.sp,
                            color = Color.White,
                        )
                        Text(
                            stringResource(id = R.string.about_us_tagline),
                            fontFamily = fontFamily,
                            fontSize = 12.sp,
                            color = Color.White,
                        )
                    }
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ){
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ){
                        Text(
                            stringResource(id = R.string.about_us_body),
                            fontFamily = fontFamily,
                            fontSize = 18.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Justify,
                            modifier = Modifier
                                .padding(start = 31.dp,end = 31.dp)
                        )
                        Column (horizontalAlignment = Alignment.CenterHorizontally,){
                            Text("CONTACT US",
                                fontFamily = fontFamily,
                                fontSize = 25.sp,
                                color = Color.Black,
                            )
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 40.dp, end = 40.dp, top = 10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ){
                                val ctx = LocalContext.current

                                val url_vk = "https://vk.com"
                                val url_inst = "https://github.com"
                                val url_tg = "https://t.me"
                                Column(
                                    modifier = Modifier
                                        .clickable {

                                            val urlIntent = Intent(
                                                Intent.ACTION_VIEW,
                                                Uri.parse(url_tg)
                                            )
                                            ctx.startActivity(urlIntent)
                                        },
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ){
                                    Image(
                                        painter = telegramIcon,
                                        contentDescription = "Telegram Icon",
                                        contentScale = ContentScale.FillHeight
                                    )
                                    Text("TG",
                                        fontFamily = fontFamily,
                                        fontSize = 14.sp,
                                        color = Color.Black,
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .clickable {

                                            val urlIntent = Intent(
                                                Intent.ACTION_VIEW,
                                                Uri.parse(url_inst)
                                            )
                                            ctx.startActivity(urlIntent)
                                        },
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ){
                                    Image(
                                        painter = instagramIcon,
                                        contentDescription = "Instagram Icon",
                                        contentScale = ContentScale.FillBounds
                                    )
                                    Text("INST",
                                        fontFamily = fontFamily,
                                        fontSize = 14.sp,
                                        color = Color.Black,
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .clickable {
                                            val urlIntent = Intent(
                                                Intent.ACTION_VIEW,
                                                Uri.parse(url_vk)
                                            )
                                            ctx.startActivity(urlIntent)
                                        },
                                    horizontalAlignment = Alignment.CenterHorizontally){
                                    Image(
                                        painter = vkIcon,
                                        contentDescription = "VK Icon",
                                        contentScale = ContentScale.FillBounds
                                    )
                                    Text("VK",
                                        fontFamily = fontFamily,
                                        fontSize = 14.sp,
                                        color = Color.Black,
                                    )
                                }

                            }
                        }
                        Box(
                            modifier = Modifier
                                .clickable { navController.navigate("Home") }
                                .height(60.dp)
                                .padding(bottom = 10.dp)
                                .width(300.dp)
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
                        ){
                            Image(
                                painter = secPartOfBackgroundImage,
                                contentDescription = "contentDescription",
                                contentScale = ContentScale.FillBounds
                            )
                            Text("GO TO NEWS",
                                fontFamily = fontFamily,
                                fontSize = 20.sp,
                                color = Color.White,
                            )

                        }
                    }


                }
            }
        }
    )
}