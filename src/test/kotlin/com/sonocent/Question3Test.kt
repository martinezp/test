package com.sonocent

import com.sonocent.Question3.squareNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Question3Test {

    @Test
    fun `Should return the square number`() {
        val response = squareNumber(6)

        assertEquals(36, response)
    }

}
