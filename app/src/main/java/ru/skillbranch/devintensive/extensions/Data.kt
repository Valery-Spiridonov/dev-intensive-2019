package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.util.*
import java.text.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when(units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time

    return this
}

enum class TimeUnits() { SECOND, MINUTE, HOUR, DAY }

fun Date.humanizeDiff(date: Date = Date()): String {
    val differenceMs: Long = Date().time - date.time
    val differenceS: Long = if(differenceMs > 0) differenceMs/1000 else 0
    val differenceM: Long = if(differenceS > 0) differenceS/60 else 0
    val differenceH: Long = if(differenceM > 0) differenceM/60 else 0
    val differenceD: Long = if(differenceH > 0) differenceH/24 else 0
    val differenceMt: Long = if(differenceD > 0) differenceD/31 else 0

    return date.toString()
}