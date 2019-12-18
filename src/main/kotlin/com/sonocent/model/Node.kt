package com.sonocent.model

class Node(val id: String) {

    private var childNodes: MutableList<Node> = mutableListOf()
    private var parentNodes: MutableList<Node> = mutableListOf()

    fun addChildNodes(nodes: List<Node>) {
        nodes.forEach {
            if (hasAscendant(it)) throw Exception("Cyclical iteration")
            it.parentNodes.add(this)
            childNodes.add(it)
        }
    }

    fun addParentNodes(nodes: List<Node>) {
        nodes.forEach {
            if (hasDescendant(it)) throw Exception("Cyclical iteration")
            it.childNodes.add(this)
            parentNodes.add(it)
        }
    }

    fun hasAscendant(node: Node): Boolean {
        if (this == node) return true
        return parentNodes.any {
            it.hasAscendant(node)
        }
    }

    fun hasDescendant(node: Node): Boolean {
        if (this == node) return true
        return childNodes.any {
            it.hasDescendant(node)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Node) return false
        return other.id == this.id
    }

}
