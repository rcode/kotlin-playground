package com.rcode.codesignal

fun solution(numbers: MutableList<Int>): MutableList<Int> {

    //set first, second, third
    var first = numbers[0]
    var second = numbers[1]
    var third = numbers[2]

    val resultList = mutableListOf<Int>()

    for(index in 0..numbers.size - 3) {
        first = numbers[index]
        second = numbers[index + 1]
        third = numbers[index + 2]
        var result = if(mutableListOf(first,second,third).isZigZag()) 1 else 0
        println("index - $index, result - $result")
        resultList.add(result)
    }

    return resultList

}

fun MutableList<Int>.isZigZag(): Boolean {
    var previousStepDirection = 0
    print("\n")
    this.forEachIndexed lit@ { index, num ->
        if(index != 0) {
            var currentStepDirection = when {
                this[index - 1] < this[index] -> 1
                this[index - 1] > this[index] -> -1
                else -> 0
            }
            print("$currentStepDirection: (${this[index - 1]}, ${this[index]}) ")
            if(currentStepDirection == previousStepDirection) {
                return false
            } else {
                previousStepDirection = currentStepDirection
            }
        }
    }
    print("\n")

    return true
}

fun main(args: Array<String>) {
    var numbersList = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toMutableList()

    println(solution(numbersList))
}