package com.sonocent

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Question4Test {

    @Test
    fun `Should return the area of a square`() {
        val area = Square(4, 5).getArea()

        assertEquals(20, area)
    }

    @Test
    fun `Should return the area of a triangle`() {
        val area = Triangle(4, 5).getArea()

        assertEquals(10, area)
    }

}
