package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.compose.*
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "menu") {

        composable("menu") { MenuScreen(navController) }
        composable("article") { ComposeArticleScreen(navController) }
        composable("task") { TaskManagerScreen(navController) }
        composable("quadrant") { QuadrantScreen(navController) }
    }
}

//////////////////// MENU ////////////////////

@Composable
fun MenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("article") },
            modifier = Modifier.fillMaxWidth()) {
            Text("Bài 1: Compose Article")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("task") },
            modifier = Modifier.fillMaxWidth()) {
            Text("Bài 2: Task Manager")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("quadrant") },
            modifier = Modifier.fillMaxWidth()) {
            Text("Bài 3: Quadrant")
        }
    }
}

//////////////////// BACK BUTTON WRAPPER ////////////////////

@Composable
fun BackButton(navController: NavController) {
    Button(onClick = { navController.popBackStack() }) {
        Text("← Quay lại")
    }
}

//////////////////// BÀI 1 ////////////////////

@Composable
fun ComposeArticleScreen(navController: NavController) {
    Column {
        BackButton(navController)
        ComposeArticle()
    }
}

@Composable
fun ComposeArticle() {
    Column {
        Image(
            painter = painterResource(R.drawable.bg_compose_background),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Jetpack Compose tutorial",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Text(
            text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

//////////////////// BÀI 2 ////////////////////

@Composable
fun TaskManagerScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        BackButton(navController)
        TaskManager()
    }
}

@Composable
fun TaskManager() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_task_completed),
            contentDescription = null
        )

        Text(
            text = "All tasks completed",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )

        Text(
            text = "Nice work!",
            fontSize = 16.sp
        )
    }
}

//////////////////// BÀI 3 ////////////////////

@Composable
fun QuadrantScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        BackButton(navController)
        QuadrantApp()
    }
}

@Composable
fun QuadrantApp() {
    Column(modifier = Modifier.fillMaxSize()) {

        Row(modifier = Modifier.weight(1f)) {
            QuadrantItem(
                "Text composable",
                "Displays text and follows Material Design.",
                Color(0xFFEADDFF),
                Modifier.weight(1f)
            )
            QuadrantItem(
                "Image composable",
                "Draws a Painter object.",
                Color(0xFFD0BCFF),
                Modifier.weight(1f)
            )
        }

        Row(modifier = Modifier.weight(1f)) {
            QuadrantItem(
                "Row composable",
                "Places children horizontally.",
                Color(0xFFB69DF8),
                Modifier.weight(1f)
            )
            QuadrantItem(
                "Column composable",
                "Places children vertically.",
                Color(0xFFF6EDFF),
                Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantItem(
    title: String,
    desc: String,
    color: Color,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(title, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(desc, textAlign = TextAlign.Center)
    }
}