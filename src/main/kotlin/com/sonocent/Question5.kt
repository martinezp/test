package com.sonocent

object Question5 {

    fun sortFloatNumbers(list: List<String>) = list
        .map { it.toFloat() }
        .sorted()
        .map{ it.toString() }

}
