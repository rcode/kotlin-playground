package com.rcode.hackerrank.string_manipulation

fun alternatingCharacters(s: String): Int {
    var currentCharacter = s[0]
    var deletions = 0
    s.drop(1).forEach {
        if(it == currentCharacter) deletions++
        else currentCharacter = it
    }

    return deletions
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s = readLine()!!

        val result = alternatingCharacters(s)

        println(result)
    }
}