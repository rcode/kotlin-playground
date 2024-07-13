package com.rcode.hackerrank.ipk

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*



/*
 * Complete the 'identifyFactors' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY userInput as parameter.
 */

fun identifyFactors(userInput: Array<Int>?): MutableList<Int> {

    var commonFactorials = mutableListOf<Int>()

    userInput?.let {
        for(index in 0..userInput.size-1) {
            if(index == 0) {
                commonFactorials.addAll(getFactorialArray(userInput[index]))
            } else {
                var factorialsForCurrentNumber = getFactorialArray(userInput[index])
                factorialsForCurrentNumber.forEach { factor ->
                    if(!commonFactorials.contains(factor))
                        commonFactorials.remove(factor)
                }
            }
        }
    }
    return commonFactorials
}

fun getFactorialArray(number: Int): MutableList<Int> {
    var factorials = mutableListOf<Int>()
    for(i in 2..number) {
        if(number%i == 0) {
            factorials.add(i)
        }
    }
    println(factorials)
    return factorials
}



fun main(args: Array<String>) {
    val userInput: Array<Int>? = readLine()
        ?.trim()
        ?.split(" ")
        ?.map { it.toInt() }
        ?.toTypedArray()

    val result = identifyFactors(userInput)

    println(result.toString())
}