package com.sonocent

import com.sonocent.Question5.sortFloatNumbers
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Question5Test {

    @Test
    fun `Should return a list ordered`() {
        val list = listOf("6.2", "5.7", "6.1", "5.11")
        val expectedList = listOf("5.11", "5.7", "6.1", "6.2")

        val orderedList = sortFloatNumbers(list)

        Assertions.assertEquals(expectedList, orderedList)
    }
}
