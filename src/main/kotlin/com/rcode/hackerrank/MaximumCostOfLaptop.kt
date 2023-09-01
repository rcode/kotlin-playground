package com.rcode.hackerrank

fun main(args: Array<String>) {
    val costCount = readLine()!!.trim().toInt()

    val cost = Array<Int>(costCount, { 0 })
    for (i in 0 until costCount) {
        val costItem = readLine()!!.trim().toInt()
        cost[i] = costItem
    }

    val labelsCount = readLine()!!.trim().toInt()

    val labels = Array<String>(labelsCount, { "" })
    for (i in 0 until labelsCount) {
        val labelsItem = readLine()!!
        labels[i] = labelsItem
    }

    val dailyCount = readLine()!!.trim().toInt()

    val result = maxCost(cost, labels, dailyCount)

    println(result)
}

/*
 * Complete the 'maxCost' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY cost
 *  2. STRING_ARRAY labels
 *  3. INTEGER dailyCount
 */

fun maxCost(cost: Array<Int>, labels: Array<String>, dailyCount: Int): Int {

    // Write your code here

    var maxCost = 0
    var index = 0

    println("dailyCount: $dailyCount")

    // Check if illegal or legal
    for(i in 0..cost.size step dailyCount) {
        var currentCount = 0
        var costForDay = 0
        while (currentCount <= dailyCount-1 && index < labels.size) {
            println("index: $index, currentCount: $currentCount")
            if(labels[index+currentCount] == "legal") {
                currentCount++
            }
            costForDay += cost[index+currentCount]

            println("costForDay: $costForDay")
            index++
              // = index % dailyCount
        }

        if(costForDay > maxCost) maxCost = costForDay
    }

    println("index: $index, dailyCount: $dailyCount")
    return maxCost;
}

/*
n = number of laptops, cost of laptops array size
each line next is the cost of the laptop
n =  the size of array of labels
each line next containing "legal" or "illegal" text
daily count = last line is the minimum count for the day to be considered
 */