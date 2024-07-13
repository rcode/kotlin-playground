package com.rcode.hackerrank.string_manipulation

import kotlin.math.abs

/**
 * Problem Link: (Making Anagrams)[https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings]
 *
 */
fun makeAnagram(a: String, b: String): Int {

    val aSet = a.toSet()
    val aCharCount = hashMapOf<Char, Int>()
    aCharCount.apply {
        a.forEach {
            if (this.contains(it)) this[it] = this[it]!! + 1 else this[it] = 1
        }
    }

    val bSet = b.toSet()
    val bCharCount = hashMapOf<Char, Int>()
    bCharCount.apply {
        b.forEach {
            if (this.contains(it)) this[it] = this[it]!! + 1 else this[it] = 1
        }
    }

    var deletionCount = 0

    val commonSet = aSet.intersect(bSet)
    val uniqueSet = aSet.union(bSet) - commonSet

    commonSet.forEach {
        deletionCount += abs(aCharCount[it]!! - bCharCount[it]!!)
    }
    uniqueSet.forEach {
        if(aCharCount.contains(it)) deletionCount += aCharCount[it]!!
        else if(bCharCount.contains(it)) deletionCount += bCharCount[it]!!
    }

    return deletionCount
}

fun main(args: Array<String>) {
    val a = readLine()!!

    val b = readLine()!!

    val res = makeAnagram(a, b)

    println(res)
}