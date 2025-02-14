package jianzhioffer

import java.util.Stack


/**
 * https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/description/
 */
class Solution_7 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


    fun deduceTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val indexMap = inorder.withIndex().associate { (index, value) -> value to index }

        when (preorder.size) {
            0 -> return null
            1 -> return TreeNode(preorder.first())
            else -> return TreeNode(preorder.first()).apply {
                val stack = Stack<TreeNode>().also {
                    it.push(this@apply)
                }

                var lastNode = this@apply

                var lastIndex = indexMap[this@apply.`val`]!!

                for (i in 1 until preorder.size) {
                    val treeNode = TreeNode(preorder[i])
                    val curIndex = indexMap[treeNode.`val`]!!
                    if (curIndex < lastIndex) {
                        lastNode.left = treeNode
                    } else {
                        var lastRoot = stack.peek()
                        while (stack.isNotEmpty() && indexMap[stack.peek().`val`]!! < lastIndex) {
                            lastRoot = stack.pop()
                        }
                        lastRoot.right = treeNode
                    }
                    lastNode = treeNode
                    lastIndex = curIndex
                    stack.push(treeNode)

                }
            }
        }

    }
}