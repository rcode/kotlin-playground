package com.rcode.hackerrank.ipk.dictandhashmap

fun sherlockAndAnagrams(s: String): Int {

    val subStrings = getAllSubStrings(s)
    val anagramStrings: HashMap<String, String> = hashMapOf<String, String>()
    var i = 0
    for(i in subStrings.indices) {
        var currentString = subStrings[i]
        subStrings.remove(currentString)
        var anagram = currentString.reversed()
        if(subStrings.contains(anagram)) {
            anagramStrings[currentString] = anagram
        }

        subStrings.add(currentString)
    }

    anagramStrings.forEach {
        print("string: ${it.key}, rev: ${it.value} \n")
    }

    return if(anagramStrings.isEmpty()) 0 else anagramStrings.size
}

fun getAllSubStrings(fullString: String): MutableList<String> {
    var i = 0
    var lastIndex = 0

    val subStringsCollection : MutableList<String> = mutableListOf<String>()
    var tempString = ""
    for(lastIndex in fullString.indices) {
        i=0
        while (i + lastIndex < fullString.length) {
            // print("i: $i, lastIndex: $lastIndex - ")
            tempString = fullString.substring(i..i+lastIndex)
            print("$tempString \n")
            subStringsCollection.add(tempString)
            i++
        }
    }
    return subStringsCollection
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s = readLine()!!

        val result = sherlockAndAnagrams(s)

        println(result)
    }
}