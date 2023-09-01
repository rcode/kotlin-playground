package com.rcode.hackerrank.ipk.arrays

import kotlin.math.absoluteValue

// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {

    var arrayNotSorted = true
    var totalSwaps = 0
    // assign values to the numbers based on their distance from their actual position

    while(arrayNotSorted) {
        var index = 0
        var maxDistancePair = Pair(0, 0) // distance and currentIndex of the numbers
        var secondMaxDistancePair = Pair(0, 0)
        while(index != arr.size-1) {
            if(arr[index].distance(index) > maxDistancePair.first)  {
                    secondMaxDistancePair = maxDistancePair
                    maxDistancePair =  maxDistancePair.copy(first = arr[index].distance(index), second = index)
            }
            else if(arr[index].distance(index) > secondMaxDistancePair.first) {
                secondMaxDistancePair = secondMaxDistancePair.copy(first = arr[index].distance(index), second = index)
            }
            index++
        }
        println("Pass: $totalSwaps, maxDistance: distance - ${maxDistancePair.first}, index - ${maxDistancePair.second} , secondMaxDistance: distance - ${secondMaxDistancePair.first}, index - ${secondMaxDistancePair.second}")
        // Check if distance does not increase
        arr.arraySwap(maxDistancePair.second, secondMaxDistancePair.second)
        arr.printArray()
        if(maxDistancePair.first == 0)
            arrayNotSorted = false

        totalSwaps++
    }

    return totalSwaps
}

fun Int.distance(index: Int): Int {
    return (index - this).absoluteValue
}

fun Array<Int>.arraySwap(indexFirst: Int, indexSecond: Int) {
    var temp = this[indexFirst]
    this[indexFirst] = this[indexSecond]
    this[indexSecond] = temp
}

fun Array<Int>.printArray() {
    println("")
    forEach {
        print("$it ")
    }
}

//fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val n = scan.nextLine().trim().toInt()
//
//    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
//
//    val res = minimumSwaps(arr)
//
//    println(res)
//}


fun minimumSwaps2(num_array: Array<Int>) {

    // if the number does not match the index then swap to correct index
    var visited = 0
    var currentIndex = 0
    var holder = 0

    var visited_indices = Array<Boolean>(num_array.size) { false }
    while(visited < num_array.size) {
        if(num_array[currentIndex] != currentIndex + 1) {
            holder = num_array[num_array[currentIndex]]
            num_array[num_array[currentIndex]] = num_array[currentIndex]
            currentIndex = num_array[currentIndex]
        }
    }
}


