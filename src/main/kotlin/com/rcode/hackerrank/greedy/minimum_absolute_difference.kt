package com.rcode.hackerrank.greedy

import kotlin.math.abs


/**
 * ()[https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms]
 */

fun minimumAbsoluteDifference(arr: Array<Int>): Int {

    var minAbsDiff = Integer.MAX_VALUE
    arr.sort()
    arr.dropLast(1).forEachIndexed { index, num ->
        if(abs(arr[index] - arr[index + 1]) < minAbsDiff) minAbsDiff = abs(arr[index] - arr[index+1])
    }

    return minAbsDiff
}



fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = minimumAbsoluteDifference(arr)

    println(result)
}