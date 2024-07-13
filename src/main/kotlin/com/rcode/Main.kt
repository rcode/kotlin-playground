package com.rcode


internal class Main {
    private val mString: String? = null
    fun getStringLength(): Int? {
        return mString?.length
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val m = Main()
            println("String length: " + m.getStringLength())

            var email: String
            email = null.toString()
            println(email)
        }
    }
}