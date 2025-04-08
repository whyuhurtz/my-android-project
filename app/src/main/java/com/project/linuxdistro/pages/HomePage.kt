package com.project.linuxdistro.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.linuxdistro.CardItem
import com.project.linuxdistro.R

@Composable
fun HomePage(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Spacer(modifier = Modifier.padding(5.dp))
        Content()
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Card (
        modifier = modifier.fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F7FA)),
    ) {
        Box (
            modifier = modifier.fillMaxWidth()
                .height(200.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_linux),
                contentDescription = "Header Background",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(250.dp), // zoom lebih besar
                alignment = Alignment.CenterEnd,
                alpha = 0.3f // opacity pudar
            )
            Text(
                text = "Linux Fans Page",
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 24.dp)
            )
        }
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    val cardItemList = listOf(
        CardItem("Debian", R.drawable.ic_debian),
        CardItem("Ubuntu", R.drawable.ic_ubuntu),
        CardItem("Linux Mint", R.drawable.ic_mint),
        CardItem("Kali Linux", R.drawable.ic_kali),
        CardItem("Arch Linux", R.drawable.ic_arch),
        CardItem("Fedora Linux", R.drawable.ic_fedora),
        CardItem("RHEL", R.drawable.ic_rhel),
        CardItem("SLES", R.drawable.ic_sles)
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        cardItemList.chunked(2).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                rowItems.forEach { cardItem ->
                    Card(
                        modifier = Modifier.size(width = 150.dp, height = 150.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F7FA))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(12.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = cardItem.drawableId),
                                contentDescription = cardItem.label,
                                modifier = Modifier.size(40.dp)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = cardItem.label,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}