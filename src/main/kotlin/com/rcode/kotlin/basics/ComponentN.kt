package com.rcode.kotlin.basics

data class Person(val name: String = "Rahul", val age: Int = 37, val height: String = "168cm")

/**
 * Iterating All Fields of a Data Class Without Reflection in Kotlin
 * Using the KClassUnpacker Annotation Processor
 * https://www.baeldung.com/kotlin/data-class-get-fields-no-reflection
 *
 */

fun main() {

    Person::class.members.forEach {

        // Pattern tested at (https://regex101.com)[https://regex101.com]
        if(!it.name.contains(Regex("^(component|copy|equals|hashCode|toString)")))
            println(it.name)

    }

    println("component values: ")

    val person = Person()

    person::class.members.forEach {
        if(it.name.contains(Regex("^(component)")))
            println(it.call(Any()))
    }
    /*println(person::class.members)
    println(person.component2())
    println(person.component3())*/
}