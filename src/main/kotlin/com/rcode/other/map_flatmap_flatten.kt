package com.rcode.other

fun main() {

    val orders = listOf(
        Order(listOf(OrderLine("Garlic", 1), OrderLine("Chives", 2))),
        Order(listOf(OrderLine("Tomato", 3), OrderLine("Garlic", 4))),
        Order(listOf(OrderLine("Potato", 5), OrderLine("Chives", 6))),
    )

    orders.flatMap { it.lines }.forEach { println(it.name) }
}

data class Order(val lines: List<OrderLine>)
data class OrderLine(val name: String, val price: Int)