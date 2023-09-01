package com.rcode.hackerrank.ds

/**
 * DS Series
 * Question 2 - 2D Array
 */

fun hourglassSum(arr: Array<Array<Int>>): Int {
    // Write your code here
    val stepPatternPair  = arrayOf(Pair(0,0),Pair(0,1),Pair(0,2),Pair(1,1),Pair(2,0),Pair(2,1),Pair(2,2))

    var sum = -44
    var hourGlassCount = 1
    // Write your code here
    for(i in 0..5) {
        for(j in 0..5) {
            var stepCount = 0
            var loopEntered = false
            var tempSum = 0
            while(i < 4 && j < 4 && stepCount < 7) {
                tempSum += arr[i + stepPatternPair[stepCount].first][j + stepPatternPair[stepCount].second]
                /*if(stepCount == 3) {
                    print("\n ${arr[i + stepPatternPair[stepCount].first][j + stepPatternPair[stepCount].second]}\n")
                } else {
                    print("${arr[i + stepPatternPair[stepCount].first][j + stepPatternPair[stepCount].second]}")
                }*/
                loopEntered = true
                stepCount++
            }

            if(loopEntered) {
                //println("\nSum of $hourGlassCount hour glass: $tempSum")
                if (tempSum > sum) sum = tempSum

                hourGlassCount++
            }
        }
    }

    return sum
}

fun main(args: Array<String>) {

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}