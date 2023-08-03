package com.example.androidsde_assignment.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun History (
    modifier: Modifier = Modifier,

    ) {
    Box(
        modifier = modifier
    ){
        Canvas(modifier = Modifier.matchParentSize() ){
            val clipPath = androidx.compose.ui.graphics.Path().apply {
                lineTo(size.width, 0f)
                lineTo(size.width, size.height)
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                close()
            }

        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(end = 32.dp)
        ) {

            Text(
                text = " ",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,

            )
        }

    }
}