package com.example.lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lazylist.model.Item

class MainActivity : ComponentActivity() {

    companion object {
        val imageList = listOf(
            Item(title = "Item 1", image = R.drawable.ic_launcher_background),
            Item(title = "Item 2", image = R.drawable.ic_launcher_background),
            Item(title = "Item 3", image = R.drawable.ic_launcher_background),
            Item(title = "Item 4", image = R.drawable.ic_launcher_background),
            Item(title = "Item 5", image = R.drawable.ic_launcher_background),
            Item(title = "Item 6", image = R.drawable.ic_launcher_background),
            Item(title = "Item 7", image = R.drawable.ic_launcher_background),
            Item(title = "Item 8", image = R.drawable.ic_launcher_background),
            Item(title = "Item 9", image = R.drawable.ic_launcher_background),
            Item(title = "Item 10", image = R.drawable.ic_launcher_background),
            Item(title = "Item 11", image = R.drawable.ic_launcher_background),
            Item(title = "Item 12", image = R.drawable.ic_launcher_background),
            Item(title = "Item 13", image = R.drawable.ic_launcher_background),
            Item(title = "Item 14", image = R.drawable.ic_launcher_background)
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            NavHost(navController = navHostController, startDestination = "home_screen") {
                composable("home_screen") {
                    HomeScreen(navHostController = navHostController)
                }

                composable("lazy_row_screen") {
                    LazyRowScreen()
                }

                composable("lazy_column_screen") {
                    LazyColumnScreen()
                }

                composable("lazy_grid_screen") {
                    LazyGridScreen()
                }
            }
        }
    }
}


@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navHostController.navigate("lazy_row_screen") }) {
            Text(text = "Lazy row")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navHostController.navigate("lazy_column_screen") }) {
            Text(text = "Lazy column")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navHostController.navigate("lazy_grid_screen") }) {
            Text(text = "Lazy grid")
        }

        Spacer(modifier = Modifier.height(10.dp))
    }
}
