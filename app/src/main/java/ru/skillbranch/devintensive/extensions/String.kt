package ru.skillbranch.devintensive.extensions

import java.util.*

fun String.truncate(length: Int = 16): String? {
    var str = this

    str = when {
        str.isBlank() -> str.trim()
        str.isNullOrEmpty() -> str
        str.trim().length <= length -> str.trim()
        str.trim().length > length -> str.substring(0,length) + "..."
        else -> str
    }

    return str
}