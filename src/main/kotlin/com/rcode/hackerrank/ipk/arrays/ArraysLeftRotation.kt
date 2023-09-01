package com.rcode.hackerrank.ipk.arrays

fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    // Write your code here
    val rotatedArray = a.copyOf()

    val effectiveRotation = d % a.size

    val startingIndex = a.size - effectiveRotation

    a.forEachIndexed { index, item ->
        rotatedArray[(index + startingIndex) % a.size] = item
    }

    return rotatedArray
}

fun rotLeft2(a: Array<Int>, d: Int): Array<Int> {

    val effectiveRotation = d % a.size

    val formerHalf = a.copyOfRange(effectiveRotation, a.size)
    val latterHalf = a.copyOfRange(0, effectiveRotation)

    return formerHalf + latterHalf
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val d = first_multiple_input[1].toInt()

    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = rotLeft2(a, d)

    println(result.joinToString(" "))
}