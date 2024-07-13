package com.rcode.hackerrank.ipk.arrays

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.reduce
import java.util.*
import java.util.stream.Stream
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * To look at this problem imagine plotting a graph with the summed values
 * with one axis representing the array length and the other axis the value of the total sum
 * for each array element.
 * This will help us come up with an algorithm that will use only the starting and end points of the operations
 * to calculate the values of the element
 * adding at the starting index and subtracting that value at the last index of the operation.
 */
fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {

    var manipulationArray = Array<Long>(n){ 0 }
    for(operations in queries) {
        manipulationArray.performAddOperations(operations[0], operations[1], operations[2])
    }

    //arrayManipulation2(queries)

    var largestNumber = 0L
    for (i in 0 until n) {
        if(manipulationArray[i] > largestNumber)
            largestNumber = manipulationArray[i]
    }

    return largestNumber
}

fun Array<Long>.performAddOperations(startIndex:Int, lastIndex: Int, numToAdd: Int) {
    this[startIndex-1] +=  numToAdd.toLong()
    if(lastIndex < this.size) {
        this[lastIndex] -= numToAdd.toLong()
    }

        this.fold("") { accumulator, value ->
            "$accumulator,$value"
        }.apply {
            println(this)
        }
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val m = first_multiple_input[1].toInt()

    val queries = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })

    for (i in 0 until m) {
        queries[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = arrayManipulation(n, queries)

    println(result)
}


fun arrayManipulation2(queries: Array<Array<Int>>): Long {
    //Store all operations in a map - Sum/Subtract the elemets in the same position

    //Store all operations in a map - Sum/Subtract the elemets in the same position
    val operations: MutableMap<Int, Int> = HashMap()

    //val it: Iterator<List<Int>> = queries.iterator()
    //while (it.hasNext()) {
    queries.forEach { operation ->
        //val operation = it.next()
        val a = operation[0]
        val b = operation[1]
        val k = operation[2]
        operations[a - 1] = operations.getOrDefault(a - 1, 0) + k
        operations[b] = operations.getOrDefault(b, 0) - k
    }

    //Sort the map indexes

    //Sort the map indexes
    val indexes: List<Int> = ArrayList(operations.keys)

    Collections.sort(indexes)

    // Calculate the runninfSum (prefix Sum) of all elements in the map and keep track of max

    // Calculate the runninfSum (prefix Sum) of all elements in the map and keep track of max
    var runningSum = 0L
    var max = 0L
    for (i in indexes.indices) {
        runningSum = runningSum!! + operations[indexes[i]]!!.toLong()
        max = Math.max(runningSum!!, max!!)
    }
    return max
}