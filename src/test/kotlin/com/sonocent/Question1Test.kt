package com.sonocent

import com.sonocent.Question1.tenToOne
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Question1Test {

    @Test
    fun `Should return numbers in descending order`() {
        val expectedList = listOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)

        val list = tenToOne()

        assertEquals(expectedList, list)
    }
}
