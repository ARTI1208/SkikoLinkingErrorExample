package com.example.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MainScreen() {

    Column {
        Text(text = Greeting().greet())
    }

}