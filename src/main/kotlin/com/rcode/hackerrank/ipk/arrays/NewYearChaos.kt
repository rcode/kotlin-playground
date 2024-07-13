package com.rcode.hackerrank.ipk.arrays

/*
 * Complete the 'minimumBribes' function below.
 *
 * The function accepts INTEGER_ARRAY q as parameter.
 */

fun minimumBribes(q: Array<Int>): Unit {

    //1 2 5 3 4 7 8 6
    var totalStepCount = 0
    for(i in (q.size - 2) downTo 0) {
        var j = i
        // find the first unsorted element, and sort it
        if(q[j] > q[j+1]) {
            print("for - ${q[i]}, ")
            var currentStepCount = 0
            // move up until it reaches its correct place
            while(j <= (q.size - 2) && q[j] > q[j+1]) {
                var temp = q[j+1]
                q[j+1] = q[j]
                q[j] = temp
                currentStepCount++
                j++
            }
            totalStepCount += currentStepCount

            if(currentStepCount > 2) {
                println("Too chaotic")
                return
            }
        }
    }
    println(totalStepCount)
}

fun minimumBribes2(q: Array<Int>): Unit {

    var totalStepCount = 0
    val num = mutableListOf<String>()
    for(i in (q.size - 1) downTo 0 ) {
        var j= i-1
        var step = 0

        while(j < i && q[j] != i) {
            j--
            var temp = q[j]
            q[j] = q[j+1]
            q[j+1] = temp
            j++
            step++
        }

        if(step >= 3) print("Too chaotic\n")

        totalStepCount += step
    }

    //println(q.map { it.toChar() }.toCharArray()) //1 2 5 3 4 7 8 6
    print("$totalStepCount\n")
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val q = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        minimumBribes(q)
    }
}