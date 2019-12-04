package com.sonocent

import com.sonocent.Question2.fizzBuzz
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Question2Test {

    @Test
    fun `Should fizz when number divisible by 3`() {
        val response = fizzBuzz(6)

        assertEquals("fizz", response)
    }

    @Test
    fun `Should buzz when number divisible by 4`() {
        val response = fizzBuzz(8)

        assertEquals("buzz", response)
    }

    @Test
    fun `Should return the number back when number not divisible by 3 or 4`() {
        val number = 5

        val response = fizzBuzz(number)

        assertEquals(number.toString(), response)
    }
}
