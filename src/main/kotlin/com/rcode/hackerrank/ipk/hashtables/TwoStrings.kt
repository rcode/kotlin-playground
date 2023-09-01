package com.rcode.hackerrank.ipk.hashtables

/**
 * https://www.hackerrank.com/challenges/two-strings/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps&h_r=next-challenge&h_v=zen
 */
fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s1 = readLine()!!

        val s2 = readLine()!!

        val result = twoStrings(s1, s2)

        println(result)
    }
}

/*
 * Complete the 'twoStrings' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING s1
 *  2. STRING s2
 */

fun twoStrings(s1: String, s2: String): String {


    var setS1 = HashSet<Char>()
    var setS2 = HashSet<Char>()
    // Write your code here
    if(s1.checkIfAlphabeticString() && s2.checkIfAlphabeticString()) {
        s1.mapTo(setS1) { it }
        s2.mapTo(setS2) { it }
        if(setS1.intersect(setS2).isNotEmpty()) return "YES"
    }

    return "NO"

}

fun String.checkIfAlphabeticString(): Boolean {
    return regexMatch.matches(this)
}

val regexMatch = Regex("[a-z]+")