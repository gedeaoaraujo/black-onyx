package com.example.blackonyx

import androidx.navigation.NavBackStackEntry
import kotlinx.datetime.TimeZone
import kotlinx.datetime.number
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock

infix fun NavBackStackEntry?.isRoute(screen: String): Boolean {
    return this?.destination?.route == screen
}

fun dateTimeNow(): String {
    val dt = Clock.System.now()
        .toLocalDateTime(TimeZone.of("America/Sao_Paulo"))
    return buildString {
        append(dt.day.toString().padStart(2, '0')); append("/")
        append(dt.month.number.toString().padStart(2, '0')); append("/")
        append(dt.year); append(" "); append(dt.hour.toString().padStart(2, '0'))
        append(":"); append(dt.minute.toString().padStart(2, '0'))
    }
}