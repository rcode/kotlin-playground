package com.rcode.nptelhrd.trees

/**
 * Height of tree is the maximum level a node is present + 1
 * (for height we include root node, for level root node is at 0 level).
 * Leaf nodes are the nodes which do not have any child nodes.
 * Nodes which are not leaf nodes are known as internal nodes.
 * The degree of a node is the number of children it has.
 *
 * An ordered tree is one in which children of each node are ordered.
 *
 * A Binary tree is an ordered tree with at most 2 children
 *
 * We can represent file system using trees.
 *
 * Binary Trees
 * We can represent arithmetic expressions using binary tree.
 * Decision trees can be represented using binary trees.
 *
 * Complete Binary tree
 * Level i has 2^i nodes
 * No of leaves at level i is 2^i
 * No of internal nodes for a tree of level i = 2^i - 1
 * Total no of nodes = 2^(i+1) - 1
 * https://chercher.tech/kotlin/tree-kotlin
 */
class Tree<T> (value: T) {
    var value:T = value
    var parent: Tree<T>? = null

    var children:MutableList<Tree<T>> = mutableListOf()

    fun addChild(node: Tree<T>){
        children.add(node)
        node.parent = this
    }

    fun size() {}

    fun elements() {}

    fun isEmpty() {}

    override fun toString(): String {
        var s = "$value"
        if (children.isNotEmpty()) {
            s += " {" + children.map { it.toString() } + " }"
        }
        return s
    }


}