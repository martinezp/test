package com.sonocent

object Question2 {

    fun fizzBuzz(number: Int): String = if (number % 3 == 0) {
        "fizz"
    } else if (number % 4 == 0){
        "buzz"
    } else {
        number.toString()
    }

}
