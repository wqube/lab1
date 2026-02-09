package com.example.lab1.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.lab1.R
import com.example.lab1.ui.Contacts
import com.example.lab1.ui.FullName

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

        val groupPadding = dimensionResource(R.dimen.group_padding)
        val contactBottomPadding = dimensionResource(R.dimen.contacts_bottom_padding)
        val transition = dimensionResource(R.dimen.transition)

        Image(
            painter = imageBackground,
            contentDescription = stringResource(R.string.background_desc),
            alpha = 0.1f,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

//        Смартфоны
        if (maxWidth < transition) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = imagePhoto,
                    contentDescription = stringResource(R.string.photo_desc),
                    modifier = Modifier.padding(bottom = groupPadding)
                )

                FullName(fullName, group, description)
            }

            Contacts(
                phoneNumber, id, email,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = contactBottomPadding)
            )

//        Планшеты
        } else {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(groupPadding),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                Image(
                    painter = imagePhoto,
                    contentDescription = stringResource(R.string.photo_desc),
                    modifier = Modifier.padding(bottom = groupPadding)
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