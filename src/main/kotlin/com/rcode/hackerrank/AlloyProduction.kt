package com.rcode.hackerrank

import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*



/*
 * Complete the 'findMaximumAlloyUnits' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY composition
 *  2. INTEGER_ARRAY stock
 *  3. INTEGER_ARRAY cost
 *  4. INTEGER budget
 */

fun findMaximumAlloyUnits(composition: Array<Int>, stock: Array<Int>, cost: Array<Int>, budget: Int): Int {
    // Write your code here
    var budgetExceeded = false
    var noOfUnitsProducable = 0

    var costOfEachUnitOfAlloy = costOfEachUnit(composition, cost)
    var costOfMetalsPresent = savingInBudget(stock, cost)

    // used as a temporary variable for
    // calculating the highest budget that can be utilized
    var budgetCalculated = 0

    while(!budgetExceeded) {

        budgetCalculated += costOfEachUnitOfAlloy
        if(budget - (budgetCalculated - costOfMetalsPresent) >= 0) {
            noOfUnitsProducable++
        } else {
            budgetExceeded = true
        }
    }

    return noOfUnitsProducable
}

fun costOfEachUnit(composition: Array<Int>, cost: Array<Int>): Int {
    var totalCost = 0;

    for(index in 0..composition.size - 1) {
        totalCost += (composition[index] + cost[index])
    }
    return totalCost
}

fun savingInBudget(stock: Array<Int>, cost: Array<Int>): Int {
    var totalCost = 0;

    for(index in 0..stock.size - 1) {
        totalCost += (stock[index] + cost[index])
    }
    return totalCost
}

fun main(args: Array<String>) {
    val compositionCount = readLine()!!.trim().toInt()

    val composition = Array<Int>(compositionCount, { 0 })
    for (i in 0 until compositionCount) {
        val compositionItem = readLine()!!.trim().toInt()
        composition[i] = compositionItem
    }

    val stockCount = readLine()!!.trim().toInt()

    val stock = Array<Int>(stockCount, { 0 })
    for (i in 0 until stockCount) {
        val stockItem = readLine()!!.trim().toInt()
        stock[i] = stockItem
    }

    val costCount = readLine()!!.trim().toInt()

    val cost = Array<Int>(costCount, { 0 })
    for (i in 0 until costCount) {
        val costItem = readLine()!!.trim().toInt()
        cost[i] = costItem
    }

    val budget = readLine()!!.trim().toInt()

    val result = findMaximumAlloyUnits(composition, stock, cost, budget)

    println(result)
}
