package com.example.lab1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.lab1.ui.theme.Lab1Theme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.core.graphics.alpha


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingPage(
                        fullName = stringResource(R.string.fullName),
                        description = stringResource(R.string.description),
                        phoneNumber = stringResource(R.string.phoneNumber),
                        id = stringResource(R.string.id),
                        email = stringResource(R.string.email)
                    )
                }

            }
        }
    }
}

@Composable
fun FullName(fullName: String, description: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    )
    {
        Text(
            text = fullName,
            fontSize = 20.sp,
            lineHeight = 10.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = description,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

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

@Composable
fun GreetingPage(
    fullName: String,
    description: String,
    phoneNumber: String,
    id: String,
    email: String,
    modifier: Modifier = Modifier)
{
    val imageBackground = painterResource(R.drawable.androidparty)
    val imagePhoto = painterResource(R.drawable._026_02_06_02_06_27)
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = imageBackground,
            contentDescription = "Background",
            alpha = 0.1F,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Image(
                painter = imagePhoto,
                contentDescription = "Photo",
                modifier = Modifier.padding(bottom = 16.dp)
            )
            FullName(
                fullName = fullName,
                description = description
            )
        }

        Contacts(
            phoneNumber = phoneNumber,
            id = id,
            email = email,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCard() {
    Lab1Theme {
        GreetingPage(
            fullName = stringResource(R.string.fullName),
            description = stringResource(R.string.description),
            phoneNumber = stringResource(R.string.phoneNumber),
            id = stringResource(R.string.id),
            email = stringResource(R.string.email)
        )
    }
}
