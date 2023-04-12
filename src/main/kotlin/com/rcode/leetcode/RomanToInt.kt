package com.rcode.leetcode

import kotlin.properties.Delegates

/*
13. Roman to Integer
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.



Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */

fun main() {
    println("Hello, World!")

    val convertedInter = RomanToInteger().romanToInt("MCMXCIV")

    print(convertedInter)
}

class RomanToInteger {

    val romanNumeralsMap = hashMapOf<Char, Int>(Pair('I', 1), Pair('V', 5), Pair('X', 10), Pair('L', 50), Pair('C', 100), Pair('D', 500), Pair('M', 1000))

    fun romanToInt(s: String): Int {
        var tempSum = 0
        var previousNumeral = ' '
        var currentNumeral = ' '
        for(i in s.length downTo 1) {

            // set current and previous values
            currentNumeral = s[i-1]
            if(previousNumeral == ' ') previousNumeral = currentNumeral

            // Check if current value is less than value of previous character, then subtract from sum
            if(romanNumeralsMap[currentNumeral]!! < romanNumeralsMap[previousNumeral]!!) {
                tempSum -= romanNumeralsMap[currentNumeral]!!
            } else {
                // else add to the sum
                tempSum += romanNumeralsMap[currentNumeral]!!
            }

            previousNumeral = currentNumeral
            println("currentNumeral: $currentNumeral-${romanNumeralsMap[currentNumeral]!!}, previousNumeral: $previousNumeral-${romanNumeralsMap[previousNumeral]}, tempSum: $tempSum")
        }

        return tempSum
    }

    fun anotherRomanToInt(s: String): Int {
        var ans = 0
        var num = 0
        for (i in s.length - 1 downTo 0) {
            when (s[i]) {
                'I' -> num = 1
                'V' -> num = 5
                'X' -> num = 10
                'L' -> num = 50
                'C' -> num = 100
                'D' -> num = 500
                'M' -> num = 1000
            }
            if (4 * num < ans) ans -= num else ans += num

            println("num: $num, ans: $ans")
        }
        return ans
    }
}
