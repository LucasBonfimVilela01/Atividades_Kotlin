package com.example.exemplonavigation.navigation

import androidx.compose.runtime.Composable
import com.example.exemplonavigation.data.getUserData
import com.example.exemplonavigation.ui.screen.HomeScreen

@Composable
fun HomeRoute(userName: String) {
    val user = getUserData(userName)

    HomeScreen(user = user)
}