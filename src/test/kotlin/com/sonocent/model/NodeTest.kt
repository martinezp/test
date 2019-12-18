package com.sonocent.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NodeTest {

    val expectedExceptionMessage = "Cyclical iteration"

    @Test
    fun `Should create a Node object`() {
        val expectedId = "abc"
        val actualNode = Node(expectedId)

        assertEquals(expectedId, actualNode.id)
    }

    @Test
    fun `Should have a list of child Nodes`() {
        val expectedChildNodes = listOf(Node("2"), Node("3"), Node("4"))

        val actualChildNodes = Node("1").apply {
            addChildNodes(expectedChildNodes)
        }.childNodes

        assertEquals(expectedChildNodes, actualChildNodes)
    }

    @Nested
    inner class `When addChildNodes invoked` {

        @Test
        fun `Should throw an exception when adding own id as child id`() {
            val expectedChildNodes = listOf(Node("1"))

            val actualException = assertThrows<Exception> {
                Node("1").apply {
                    addChildNodes(expectedChildNodes)
                }
            }

            assertEquals(expectedExceptionMessage, actualException.message)
        }

        @Test
        fun `Should throw an exception when adding a node generating a cyclical graph`() {
            val parentNode = Node("1")
            val childNode = Node("2")
            parentNode.addChildNodes(listOf(childNode))


            val actualException = assertThrows<Exception> {
                childNode.addChildNodes(listOf(parentNode))
            }

            assertEquals(expectedExceptionMessage, actualException.message)
        }
    }

    @Nested
    inner class `When addParents invoked` {

        @Test
        fun `Should throw an exception when adding own id as parent id`() {
            val node = Node("1")
            val nodes = listOf(Node("1"))

            val actualException = assertThrows<Exception> {
                node.addParentNodes(nodes)
            }

            assertEquals(expectedExceptionMessage, actualException.message)
        }

        @Test
        fun `Should throw an exception when trying adding a child as parent`() {
            val parentNode = Node("1")
            val childNode = Node("2")
            parentNode.addChildNodes(listOf(childNode))

            val actualException = assertThrows<Exception> {
                parentNode.addParentNodes(listOf(childNode))
            }

            assertEquals(expectedExceptionMessage, actualException.message)
        }
    }

    @Nested
    inner class `When isDescendant invoked` {

        @Test
        fun `Should return true if the node is a descendant node`() {
            val parentNode = Node("1")
            val childNode = Node("2")
            parentNode.addChildNodes(listOf(childNode))

            val isDescendant = parentNode.hasDescendant(childNode)

            assertTrue(isDescendant)
        }

        @Test
        fun `Should return false if the node is not a descendant node`() {
            val parentNode = Node("1")
            val childNode = Node("2")
            parentNode.addChildNodes(listOf(childNode))

            val isDescendant = parentNode.hasDescendant(Node("3"))

            assertFalse(isDescendant)
        }
    }

    @Nested
    inner class WhenIsAscendantInvoked {

        @Test
        fun `Should return true if the node is an ascendant node`() {
            val parentNode = Node("1")
            val childNode = Node("2")
            parentNode.addChildNodes(listOf(childNode))

            val isAscendant = childNode.hasAscendant(parentNode)

            assertTrue(isAscendant)
        }

        @Test
        fun `Should return false if the node is not an ascendant node`() {
            val parentNode = Node("1")
            val childNode = Node("2")
            parentNode.addChildNodes(listOf(childNode))

            val isAscendant = parentNode.hasAscendant(childNode)

            assertFalse(isAscendant)
        }
    }

}
