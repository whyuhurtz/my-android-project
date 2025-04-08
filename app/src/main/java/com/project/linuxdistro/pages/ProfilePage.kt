package com.project.linuxdistro.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.project.linuxdistro.R

@Composable
fun ProfilePage(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize()
            .background(colorResource(R.color.lavender)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Profile Page",
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}