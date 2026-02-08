package com.example.lab1.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Contacts(phoneNumber: String, id: String, email: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    )
    {
        Text(text = phoneNumber)
        Text(text = id)
        Text(text = email)
    }
}