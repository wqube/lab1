package com.example.lab1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.lab1.ui.theme.Lab1Theme
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab1.ui.screen.GreetingPage

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1Theme {
                Scaffold { padding ->
                    GreetingPage(
                        fullName = stringResource(R.string.fullName),
                        group = stringResource(R.string.group),
                        description = stringResource(R.string.description),
                        phoneNumber = stringResource(R.string.phoneNumber),
                        id = stringResource(R.string.id),
                        email = stringResource(R.string.email),
                        modifier = Modifier.padding(padding)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun BusinessCardPortraitPreview() {
    Lab1Theme {
        GreetingPage(
            fullName = stringResource(R.string.fullName),
            group = stringResource(R.string.group),
            description = stringResource(R.string.description),
            phoneNumber = stringResource(R.string.phoneNumber),
            id = stringResource(R.string.id),
            email = stringResource(R.string.email)
        )
    }
}

@Preview(showBackground = true, widthDp = 800, heightDp = 480)
@Composable
fun BusinessCardLandscapePreview() {
    Lab1Theme {
        GreetingPage(
            fullName = stringResource(R.string.fullName),
            group = stringResource(R.string.group),
            description = stringResource(R.string.description),
            phoneNumber = stringResource(R.string.phoneNumber),
            id = stringResource(R.string.id),
            email = stringResource(R.string.email)
        )
    }
}
