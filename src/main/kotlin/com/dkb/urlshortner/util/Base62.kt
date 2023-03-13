package com.dkb.urlshortner.util

private const val CHARSET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

fun Long.encode(): String {
    var remainder = this
    val buffer = CharArray(64)
    var index = buffer.size

    if (remainder == 0L) {
        return "0"
    }
    while (remainder > 0) {
        buffer[--index] = CHARSET[(remainder % 62).toInt()]
        remainder /= 62
    }
    return String(buffer, index, buffer.size - index)
}