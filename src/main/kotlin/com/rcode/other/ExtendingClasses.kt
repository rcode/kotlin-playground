package com.rcode.other

open class Vehicle {

    open fun make() {
        println("Class Vehicle")
    }
}

class Car: Vehicle() {
    override fun make() {
        println("Class Car")
    }
}

class Bike: Vehicle() {
    override fun make() {
        println("Class Bike")
    }
}

fun main() {

    val c1 = Car()
    val c2 = Car()
    val b1 = Bike()
    val b2 = b1

    println(c1 is Car)
    println(c1 is Vehicle)
    println(b1.equals(Car()))
    println(b1 is Bike)
}