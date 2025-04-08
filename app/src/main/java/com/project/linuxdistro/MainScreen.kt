package com.project.linuxdistro

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import com.project.linuxdistro.pages.HomePage
import com.project.linuxdistro.pages.NotificationsPage
import com.project.linuxdistro.pages.ProfilePage

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    /* List of navigation bottom bar menu's */
    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Notifications", Icons.Default.Notifications),
        NavItem("Profile", Icons.Default.Person)
    )

    /* Set current position in the nav bottom bar */
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    // Main screen layout : scaffold
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = "Icon")
                        },
                        label = {
                            Text (text = navItem.label)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(
            modifier = Modifier.padding(innerPadding),
            selectedIndex
        )
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex : Int) {
    when(selectedIndex) {
        0-> HomePage(modifier = modifier)
        1-> NotificationsPage()
        2-> ProfilePage()
    }
}