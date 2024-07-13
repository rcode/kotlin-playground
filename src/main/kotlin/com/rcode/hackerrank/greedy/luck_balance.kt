package com.rcode.hackerrank.greedy


/**
 * ()[https://www.hackerrank.com/challenges/luck-balance/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms]
 */
fun luckBalance(k: Int, contests: Array<Array<Int>>): Int {

    var contestToLoose = k
    contests.sortWith(
        compareByDescending { it[0]}
    )

    var accumulatedLuck = 0
    contests.forEach {
        when {
            (it[1] == 1 && contestToLoose >= 1) -> {
                contestToLoose--
                accumulatedLuck += it[0]
                println("(${it[0]},${it[1]}) - $accumulatedLuck")
            }
            (it[1] == 0) -> {
                accumulatedLuck += it[0]
                println("(${it[0]},${it[1]}) - $accumulatedLuck")
            }
            else -> {
                accumulatedLuck -= it[0]
                println("(${it[0]},${it[1]}) - $accumulatedLuck")
            }
        }
    }

    return accumulatedLuck

}

fun main(args: Array<String>) {
    val firstMultipleInput = readLine()!!.trimEnd().split(" ")

    val n = firstMultipleInput[0].toInt()

    val k = firstMultipleInput[1].toInt()

    val contests = Array<Array<Int>>(n) { Array<Int>(2) { 0 } }

    for (i in 0 until n) {
        contests[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = luckBalance(k, contests)

    println(result)
}