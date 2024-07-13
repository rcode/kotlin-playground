package com.rcode

fun printWithTimePassed(value: Any, startTime: Long) {

    println(" ${(System.currentTimeMillis() - startTime)}ms: $value" )
}