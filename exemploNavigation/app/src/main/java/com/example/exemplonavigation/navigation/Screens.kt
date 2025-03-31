package com.example.exemplonavigation.navigation

import com.example.exemplonavigation.navigation.Routes.HOME_ROUTE
import com.example.exemplonavigation.navigation.Routes.LOGIN_ROUTE

sealed class Screens(val route: String) {
    object LoginScreen : Screens(LOGIN_ROUTE)
    object HomeScreen : Screens(HOME_ROUTE)
}