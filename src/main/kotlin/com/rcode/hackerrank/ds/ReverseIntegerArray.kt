package com.rcode.hackerrank.ds


/**
 * DS Series
 * Question 1 - Array
 */

fun reverseArray(a: Array<Int>): Array<Int> {
    val reversedArray = Array<Int>(a.size) { 0 }
    println("size: reversed - ${reversedArray.size}, original - ${a.size}")
    // Write your code here
    for(i in a.size downTo 1) {
        reversedArray[a.size - i] = a[i - 1]
    }

    return reversedArray
}

fun main(args: Array<String>) {
    val arrCount = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val res = reverseArray(arr)

    println(res.joinToString(" "))
}
