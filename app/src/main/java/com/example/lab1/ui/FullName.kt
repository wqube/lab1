package com.example.lab1.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1.R

@Composable
fun FullName(fullName: String, group: String, description: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    )
    {
        val nameSize = dimensionResource(R.dimen.text_name).value.sp
        val groupSize = dimensionResource(R.dimen.text_group).value.sp
        val descriptionSize = dimensionResource(R.dimen.text_description).value.sp
        val groupPadding = dimensionResource(R.dimen.group_padding)
        Text(
            text = fullName,
            fontSize = nameSize,
            lineHeight = 10.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = group,
            fontSize = groupSize,
            modifier = Modifier
                .padding(groupPadding)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = description,
            fontSize = descriptionSize,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}