package com.sonocent

object Question3 {

    fun squareNumber(number: Int) = number * number

    fun printSquareNumberFromOneToTenThousand() = (1000..10000).forEach { print(squareNumber(it)) }

}
