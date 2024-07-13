package com.rcode.kotlin.basics

open class Smartphone {
    var smartphoneName: String = ""
}

class Android: Smartphone() {}

class iPhone: Smartphone() {}

fun main(args: Array<String>) {
    println("Android : ${Android() is Smartphone}")
}

class AnotherClass() {
    companion object {
        const val phoneNumber: Int = 23

    }

    private val imei = Android()

    fun printData() {
        imei.smartphoneName = "New one"
    }
}