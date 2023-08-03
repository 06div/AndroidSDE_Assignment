package com.example.androidsde_assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.androidsde_assignment.feature_data.data.data_source.AppDatabase
import com.example.androidsde_assignment.presentation.MainViewModel
import com.example.androidsde_assignment.presentation.YourAppNameApp
import com.example.androidsde_assignment.presentation.expressionApiService
import com.example.androidsde_assignment.ui.theme.AndroidSDE_AssignmentTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = Room.databaseBuilder(applicationContext,
            AppDatabase::class.java, "expression-db").build()
        val viewModel: MainViewModel by viewModels {
            MainViewModel(expressionApiService, database) }
//        setContent {
//            YourAppNameApp(viewModel = viewModel)
//        }
        setContent {
            AndroidSDE_AssignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    YourAppNameApp(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidSDE_AssignmentTheme {
        Greeting("Android")
    }
}