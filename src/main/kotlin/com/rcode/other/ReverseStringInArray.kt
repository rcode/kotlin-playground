package com.rcode.other


fun main() {

    var stringNames = mutableListOf("Rahul", "Sandeep", "Raj")
    stringNames.forEachIndexed{ i,name ->
        stringNames[i] = reverseString(name)
    }
}

fun reverseString(name: String): String {
    var tempName = ""
    for(i in name.length-1 downTo 0) {
        tempName += name[i]
    }
    return tempName
}

class ReverseStringInArray {
    // iterate over each item
    // reverse the string and store it back
}

