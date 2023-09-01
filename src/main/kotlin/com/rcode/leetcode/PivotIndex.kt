package com.rcode.leetcode

fun main() {
    val nums = intArrayOf(2,1,-1)
    var pivotIndex = PivotIndex().pivotIndex(nums)
    println("Pivot index: $pivotIndex")
}

class PivotIndex {

    fun pivotIndex(nums: IntArray): Int {
        var leftSum = 0
        var rightSum = 0

        var pivotIndex = -1
        var leftIndex = 0
        var rightIndex = nums.size

        //leftSum = nums[leftIndex]
        while(leftIndex < rightIndex) {

            if(leftSum > rightSum) {
                rightSum += nums[--rightIndex]
                println("when(leftSum > rightSum) leftIndex: $leftIndex, leftSum: $leftSum, rightIndex: $rightIndex, rightSum: $rightSum")
            } else if (leftSum < rightSum) {
                leftSum += nums[++leftIndex]
                println("when(leftSum < rightSum)) leftIndex: $leftIndex, leftSum: $leftSum, rightIndex: $rightIndex, rightSum: $rightSum")
            } else {
                println("when(leftSum = rightSum)) leftIndex: $leftIndex, leftSum: $leftSum, rightIndex: $rightIndex, rightSum: $rightSum")
                if(leftIndex + 1 == rightIndex - 1) {
                    pivotIndex = leftIndex + 1
                    break
                } else {
                    break
                }
            }
        }
        return pivotIndex
    }
}