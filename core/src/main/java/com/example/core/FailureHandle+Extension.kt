package com.example.core

fun <T> tryOrNull(throwableAction: () -> T): T? =
    try {
        throwableAction()
    } catch (e: Exception) {
        null
    }