package com.rcode.hackerrank.ipk

/*
 * Complete the 'repeatedString' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. LONG_INTEGER n
 */

fun repeatedString(s: String, n: Long): Long {
    // find the number of times letter appears in single string
    var count = 0

    s.forEach {
        if (it == 'a')
            count++
    }

    val repetitions = n / s.length

    var repetitionCount = repetitions * count

    val remainingStringLength = (n % s.length).toInt()

    var remainingCount = 0


    s.substring(0, remainingStringLength).forEach {
        if (it == 'a')
            remainingCount++
    }


    print("count: $count \n")
    print("repetitions: $repetitions \n")
    print("remainingStringLength: $remainingStringLength \n")
    print("remainingCount: $remainingCount \n")


    // get total number of repetitions.
    return repetitionCount + remainingCount
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val n = readLine()!!.trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}