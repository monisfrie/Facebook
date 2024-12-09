package com.example.facebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.facebook.ui.theme.FacebookTheme
import com.example.facebook.ui.theme.Model
import com.example.facebook.ui.theme.ModelVideos
import androidx.compose.material3.HorizontalDivider as HorizontalDivider1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FacebookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyNavigation() {
    val navController = androidx.navigation.compose.rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("busqueda") {
            BusquedaScreen(navController, modifier = Modifier)
        }
        composable("videos") {
            VideosScreen(navController, modifier = Modifier)
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            horizontalArrangement = Arrangement.Start

        ) {
            Image(
                painter = painterResource(id = R.drawable.marca),
                contentDescription = "Facebook",
                modifier = Modifier.size(100.dp)
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp),
                horizontalArrangement = Arrangement.End
            ) {

                Button(
                    onClick = { navController.navigate("busqueda") },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .border(width = 2.dp, color = Color.Gray, shape = CircleShape)
                        .size(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            painter = painterResource(id = R.drawable.lupa),
                            contentDescription = "buscador",
                            modifier = Modifier.size(32.dp),
                            tint = Color.Unspecified
                        )
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .border(width = 2.dp, color = Color.Gray, shape = CircleShape)
                        .size(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp)

                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            painter = painterResource(id = R.drawable.menu),
                            contentDescription = "menu",
                            modifier = Modifier.size(32.dp),
                            tint = Color.Unspecified
                        )
                    }
                }
            }
        }
        Row(modifier = Modifier.fillMaxWidth())
        {
            Button(
                onClick = { },
                modifier = Modifier
                    .background(Color.Transparent),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Inicio",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .background(Color.Transparent),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.users),
                    contentDescription = "Usuarios",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
            }
            Button(
                onClick = { },
                modifier = Modifier
                    .background(Color.Transparent),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.messages),
                    contentDescription = "Mensajes",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { navController.navigate("videos") },
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(0.25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.video),
                    contentDescription = "Vídeos",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
            }
            Button(
                onClick = { },
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(0.25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = "Notificaciones",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(0.25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.shop),
                    contentDescription = "Tienda",
                    modifier = Modifier.size(30.dp),
                    tint = Color.Unspecified
                )

            }
        }
        HorizontalDivider1(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 1.dp,
            color = Color.Gray
        )
        Column { LazyColumnNoticias(modifier = Modifier) }
    }
}


@Composable
fun VideosScreen(navController: NavHostController, modifier: Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth())
        {
            Button(
                onClick = { },
                modifier = Modifier
                    .background(Color.Transparent),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Inicio",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .background(Color.Transparent),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.users),
                    contentDescription = "Usuarios",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
            }
            Button(
                onClick = { },
                modifier = Modifier
                    .background(Color.Transparent),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.messages),
                    contentDescription = "Mensajes",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { navController.navigate("videos") },
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(0.25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.video),
                    contentDescription = "Vídeos",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )

            }
            Button(
                onClick = { },
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(0.25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = "Notificaciones",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )


            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(0.25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.shop),
                    contentDescription = "Tienda",
                    modifier = Modifier.size(30.dp),
                    tint = Color.Unspecified
                )

            }
        }
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 1.dp,
            color = Color.Gray
        )
        Text(
            "Vídeos",
            fontSize = 20.sp,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(start = 10.dp)
        )
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 2.dp,
            color = Color.Gray
        )
        Column { LazyColumnVideos(modifier = Modifier) }
    }
}


@Composable
fun LazyColumnNoticias(modifier: Modifier) {
    val items = getData()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(items.size) {
            itemNoticia(items[it])
        }
    }
}

@Composable
fun itemNoticia(model: Model) {
    Column {
        Image(painter = painterResource(id = model.imagen), contentDescription = "Noticia")
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 1.dp,
            color = Color.Gray
        )
    }
}


@Composable
fun getData(): List<Model> {
    return listOf(
        Model(R.drawable.noticia1),
        Model(R.drawable.noticia2),
        Model(R.drawable.noticia3)
    )

}
@Composable
fun LazyColumnVideos(modifier: Modifier) {
    val items = getVideos()
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(items.size) {
            itemVideo(items[it])
        }
    }
}
@Composable
fun itemVideo(model: ModelVideos) {
    Column {
        Image(painter = painterResource(id = model.imagen), contentDescription = "Video")
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 1.dp,
            color = Color.Gray
        )

    }
}
 @Composable
 fun getVideos(): List<ModelVideos> {
     return listOf(
         ModelVideos(R.drawable.video1),
         ModelVideos(R.drawable.video2),
         ModelVideos(R.drawable.video3)
     )
 }

@Composable
fun BusquedaScreen(navController: NavHostController, modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            horizontalArrangement = Arrangement.Start


        ) {

            Button(
                onClick = { navController.navigate("main") },
                modifier = Modifier
                    .background(Color.Transparent)
                    .size(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(0.dp)
            ) {

                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        painter = painterResource(id = R.drawable.volver),
                        contentDescription = "Volver",
                        modifier = Modifier.size(32.dp),
                        tint = Color.Unspecified
                    )
                }

            }
            VisualSearchBarWithInput()
            Row(
                Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            )
            {
                Button(
                    onClick = { navController.navigate("busqueda") },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .size(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            painter = painterResource(id = R.drawable.lupa),
                            contentDescription = "Buscar",
                            modifier = Modifier.size(32.dp),
                            tint = Color.Unspecified
                        )
                    }
                }

            }

        }
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 1.dp,
            color = Color.Gray
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),

            )
        {
            Text(
                "Recientes",
                fontSize = 20.sp,
                color = Color.Black,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
        ) {
            Box(contentAlignment = Alignment.TopStart) {
                Icon(
                    painter = painterResource(id = R.drawable.lupa),
                    contentDescription = "Buscar",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
            }
            Spacer(modifier = Modifier.width(40.dp))
            Text("Animales", fontSize = 20.sp, color = Color.Gray)
            Spacer(modifier = Modifier.width(200.dp))
            Box(contentAlignment = Alignment.TopEnd) {
                Icon(
                    painter = painterResource(id = R.drawable.puntitos),
                    contentDescription = "Opciones",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
        ) {
            Box(contentAlignment = Alignment.TopStart) {
                Icon(
                    painter = painterResource(id = R.drawable.lupa),
                    contentDescription = "Buscar",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
            }
            Spacer(modifier = Modifier.width(40.dp))
            Text("Personas", fontSize = 20.sp, color = Color.Gray)
            Spacer(modifier = Modifier.width(200.dp))
            Box(contentAlignment = Alignment.TopEnd) {
                Icon(
                    painter = painterResource(id = R.drawable.puntitos),
                    contentDescription = "Opciones",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisualSearchBarWithInput() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text("Búsqueda", color = Color.Gray, fontSize = 16.sp) },
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray)
            .height(32.dp)

    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    MyNavigation()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FacebookTheme {
        Greeting("Android")
    }
}