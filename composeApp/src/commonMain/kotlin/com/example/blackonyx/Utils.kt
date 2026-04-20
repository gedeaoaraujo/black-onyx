package com.example.blackonyx

import androidx.navigation.NavBackStackEntry
import kotlinx.datetime.TimeZone
import kotlinx.datetime.number
import kotlinx.datetime.toLocalDateTime
import kotlin.reflect.KClass
import kotlin.time.Clock


infix fun <T: Screen>NavBackStackEntry?.isRoute(screen: KClass<T>): Boolean {
    return this?.destination?.route
        ?.contains(screen.qualifiedName.orEmpty()) == true
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