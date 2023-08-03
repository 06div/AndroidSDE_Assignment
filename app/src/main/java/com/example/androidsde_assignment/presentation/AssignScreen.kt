package com.example.androidsde_assignment.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidsde_assignment.feature_data.domain.AssignmentUsecase.ExpressionAPIService

import com.example.androidsde_assignment.feature_data.domain.model.ExpressionResult
import com.example.androidsde_assignment.ui.theme.AndroidSDE_AssignmentTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



val BASE_URL = "http://api.mathjs.org/v4/"
val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
val expressionApiService =
    retrofit.create(ExpressionAPIService::class.java)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(  exApi : ExpressionAPIService) {

    var expression by remember { mutableStateOf("") }
    var results by remember { mutableStateOf(emptyList<ExpressionResult>())
    }
    var showResults by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TopAppBar(
            title = { Text(text = "Expression Evaluator") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField(
            value = expression,
            onValueChange = { expression = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    exApi.evaluateExpression(expression)
                    showResults = true
                }
            ),
            textStyle = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (showResults) {
            ResultsList(results = results)
        }
    }
}
@Composable
fun ResultsList(results: List<ExpressionResult>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Results",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(results) { result ->
                Text(text = "${result.expression} = ${result.result}")
            }
        }
    }
}
@Composable
fun YourAppNameApp() {
    AndroidSDE_AssignmentTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            MainScreen()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    YourAppNameApp()
}

