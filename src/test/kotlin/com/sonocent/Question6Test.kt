package com.sonocent

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class Question6Test {

    @Test
    fun `Should return true if the word is anagram`() {
        val word1 = "sonocent"
        val word2 = "tneconos"

        val response = Question6.isAnagram(word1, word2)

        assertTrue(response)
    }

    @Test
    fun `Should return false if the word is not anagram`() {
        val word1 = "sonocent"
        val word2 = "sonOcent"

        val response = Question6.isAnagram(word1, word2)

        assertFalse(response)
    }

}
