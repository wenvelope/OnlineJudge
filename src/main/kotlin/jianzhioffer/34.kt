package jianzhioffer

import java.util.LinkedList

class Solution_34 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun pathTarget(root: TreeNode?, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val deque = LinkedList<Pair<List<TreeNode>, TreeNode>>()
        if (root == null) {
            return emptyList()
        }
        deque.add(Pair(mutableListOf(root), root))
        while (deque.isNotEmpty()) {
            val node = deque.poll()
            val value = node.first.sumOf { it.`val` }
            val treeNode = node.second
            if (treeNode.left == null && treeNode.right == null) {
                if (value == target) {
                    result.add(node.first.map { it.`val` })
                }
            }
            treeNode.left?.let {
                val list = mutableListOf<TreeNode>()
                list.addAll(node.first)
                list.add(it)
                deque.add(Pair(list, it))
            }
            treeNode.right?.let {
                val list = mutableListOf<TreeNode>()
                list.addAll(node.first)
                list.add(it)
                deque.add(Pair(list, it))
            }
        }
        return result

    }
}