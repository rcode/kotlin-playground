package com.rcode.hackerrank.ipk.hashtables

/**
 [https://www.hackerrank.com/challenges/ctci-ransom-note/problem?isFullScreen=true}]
*/

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val m = first_multiple_input[0].toInt()

    val n = first_multiple_input[1].toInt()

    val magazine = readLine()!!.trimEnd().split(" ").toTypedArray()

    val note = readLine()!!.trimEnd().split(" ").toTypedArray()

    print(checkMagazine(magazine, note))
}

fun checkMagazine(mag: Array<String>, note: Array<String>): String {

    if(mag.size < note.size)
        return "No"

    // contains all the words in the magazine
    var magCollection = mag.toMutableList()

    // contains number of a times each distinct word appears
    val magHashMap : HashMap<String, Int> = hashMapOf()
    var matched = 0
    var index = 0

    magCollection.forEach {
        if(magHashMap.contains(it))
            magHashMap[it] = magHashMap[it]?.plus(1)!!  // add one to the number
        else {
            magHashMap[it] = 1
            if(note.contains(it)) return "YES"
        }
    }

    note.forEach {
        try {
            if (!magHashMap.contains(it))
                return "No"
            else if (magHashMap[it]!! > 0) {
                magHashMap[it] = magHashMap[it]?.minus(1)!!
            } else {
                return "No"
            }
        } catch (e: NullPointerException) {
            return "No"
        }
    }

    return "Yes"

}