package com.example.lab1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.lab1.ui.Contacts
import com.example.lab1.ui.FullName
import com.example.lab1.ui.theme.Lab1Theme
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun GreetingPage(
    fullName: String,
    group: String,
    description: String,
    phoneNumber: String,
    id: String,
    email: String,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val imageBackground = painterResource(R.drawable.androidparty)
        val imagePhoto = painterResource(R.drawable._026_02_06_02_06_27)

        val avatarPadding = dimensionResource(R.dimen.group_padding)
        val contactBottomPadding = dimensionResource(R.dimen.contacts_bottom_padding)

        Image(
            painter = imageBackground,
            contentDescription = stringResource(R.string.background_desc),
            alpha = 0.1f,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        if (maxWidth < 600.dp) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = imagePhoto,
                    contentDescription = stringResource(R.string.photo_desc),
                    modifier = Modifier.padding(bottom = avatarPadding)
                )

                FullName(fullName, group, description)
            }

            Contacts(
                phoneNumber, id, email,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = contactBottomPadding)
            )

        } else {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                Image(
                    painter = imagePhoto,
                    contentDescription = stringResource(R.string.photo_desc),
                    modifier = Modifier.padding(bottom = avatarPadding)
                )

                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    FullName(fullName, group, description)

                    Spacer(modifier = Modifier.height(16.dp))

                    Contacts(phoneNumber, id, email)
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
