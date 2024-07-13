package com.rcode.hackerrank.ipk.arrays

import org.jetbrains.annotations.TestOnly
import java.util.*
import kotlin.math.absoluteValue

// Try this solution
// https://favtutor.com/blogs/minimum-swaps-to-sort#:~:text=For%20example%2C%20consider%20the%20array%20A%20%3D%20%5B5%2C%203,5%2C%206%2C%208%5D.

// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {

    var arrayNotSorted = true
    var totalSwaps = 0
    // assign values to the numbers based on their distance from their actual position

    while (arrayNotSorted) {
        var index = 0
        var maxDistancePair = Pair(0, 0) // distance and currentIndex of the numbers
        var secondMaxDistancePair = Pair(0, 0)
        while (index != arr.size - 1) {
            if (arr[index].distance(index) > maxDistancePair.first) {
                secondMaxDistancePair = maxDistancePair
                maxDistancePair = maxDistancePair.copy(first = arr[index].distance(index), second = index)
            } else if (arr[index].distance(index) > secondMaxDistancePair.first) {
                secondMaxDistancePair = secondMaxDistancePair.copy(first = arr[index].distance(index), second = index)
            }
            index++
        }
        println("Pass: $totalSwaps, maxDistance: distance - ${maxDistancePair.first}, index - ${maxDistancePair.second} , secondMaxDistance: distance - ${secondMaxDistancePair.first}, index - ${secondMaxDistancePair.second}")
        // Check if distance does not increase
        arr.arraySwap(maxDistancePair.second, secondMaxDistancePair.second)
        arr.printArray()
        if (maxDistancePair.first == 0)
            arrayNotSorted = false

        totalSwaps++
    }

    return totalSwaps
}

fun Int.distance(index: Int): Int {
    return (index - this).absoluteValue
}

fun Array<Int>.arraySwap(indexFirst: Int, indexSecond: Int) {
    var temp = this[indexFirst]
    this[indexFirst] = this[indexSecond]
    this[indexSecond] = temp
}

fun Array<Int>.printArray() {
    println("")
    forEach {
        print("$it ")
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = fromGFG(arr) //minimumSwaps(arr)

    println(res)
}


fun minimumSwaps2(num_array: Array<Int>) {

    // if the number does not match the index then swap to correct index
    var visited = 0
    var currentIndex = 0
    var holder = 0

    var visited_indices = Array<Boolean>(num_array.size) { false }
    while (visited < num_array.size) {
        if (num_array[currentIndex] != currentIndex + 1) {
            holder = num_array[num_array[currentIndex]]
            num_array[num_array[currentIndex]] = num_array[currentIndex]
            currentIndex = num_array[currentIndex]
        }
    }
}


fun fromGFG(arr: Array<Int>): Int {

    val n: Int = arr.size

    // Create two arrays and
    // use as pairs where first
    // array is element and second array
    // is position of first element
    val arrpos = ArrayList<Pair<Int, Int>>()
    for (i in 0 until n) arrpos.add(
        Pair<Int, Int>(arr[i], i)
    )
    print("Un-Sorted array:" )
    for (x in arrpos) print("(${x.first}:${x.second}) ")
    print("\n\n\n")


    // Sort the array by array element values to
    // get right position of every element as the
    // elements of second array.
    arrpos.sortWith<Pair<Int, Int>> { o1, o2 ->
        if (o1?.first!! > o2?.first!!) 1 else if (o1?.first?.equals(o2.first)!!) 0 else -1
    }
    print("Sorted array:" )
    for (x in arrpos) print("(${x.first}:${x.second}) ")
    print("\n\n\n")

    // To keep track of visited elements. Initialize
    // all elements as not visited or false.
    val vis = arrayOfNulls<Boolean>(n)
    Arrays.fill(vis, false)

    // Initialize result
    var ans = 0

    // Traverse array elements
    for (i in 0 until n) {
        println("\n\nCurrently Traversing : $i,${arrpos[i].second}")
        // already swapped and corrected or
        // already present at correct pos
        if (vis[i]!! || arrpos[i].second === i) {
            println("Skipped \n\n")
            continue
        }

        // find out the number of  node in
        // this cycle and add in ans
        var cycle_size = 0
        var j = i
        while (!vis[j]!!) {
            println("visited: $j,${arrpos[j].second}")
            vis[j] = true

            // move to next node
            j = arrpos[j].second
            cycle_size++
        }

        // Update answer by adding current cycle.
        if (cycle_size > 0) {
            ans += cycle_size - 1
        }
    }

    // Return result
    return ans

}
