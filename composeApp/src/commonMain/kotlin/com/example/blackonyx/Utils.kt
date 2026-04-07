package com.example.blackonyx

import androidx.navigation.NavBackStackEntry

infix fun NavBackStackEntry?.isRoute(screen: String): Boolean {
    return this?.destination?.route == screen
}