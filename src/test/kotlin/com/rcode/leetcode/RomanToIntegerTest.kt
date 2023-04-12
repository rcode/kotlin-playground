package com.rcode.leetcode

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RomanToIntegerTest {

    @Test
    fun romanToInt() {
        assertEquals(1994, RomanToInteger().romanToInt("MCMXCIV"))
    }
}