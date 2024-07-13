package com.rcode.hackerrank.sorting

fun countSwaps(a: Array<Int>): Unit {
    var swaps = 0
    for(i in a.indices) {
        for(j in 0 until a.size-1) {
            if(a[j] > a[j+1])  {
                a.swap(j, j+1)
                swaps++
            }
        }
    }

    println("Array is sorted in $swaps swaps.")
    println("First Element: ${a.first()}")
    println("Last Element: ${a.last()}")
}

fun <T> Array<T>.swap(aIndex: Int, bIndex: Int) {
    var temp = this[aIndex]
    this[aIndex] = this[bIndex]
    this[bIndex] = temp
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    countSwaps(a)
}