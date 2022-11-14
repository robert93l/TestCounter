package com.example.core

val Exception.tag: String get() = javaClass.simpleName

fun Exception.message(): String = message ?: tag