package jianzhioffer

import com.sun.tools.javac.jvm.ByteCodes.ret

class Solution_26 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


    fun isSubStructure(A: TreeNode?, B: TreeNode?): Boolean {

        if (B == null) {
            return false
        }
        if (A == null) {
            return false
        }

        //寻找头节点
        val arrayDeque = ArrayDeque<TreeNode>()
        val arrayBQueue = ArrayDeque<TreeNode>()
        arrayBQueue.add(B)
        arrayDeque.add(A)

        var rootA: TreeNode? = null

        while (arrayDeque.isNotEmpty()) {
            val node = arrayDeque.removeFirst()

            if (node.`val` == B.`val`) {
                rootA = node
            }

            if (node.left != null) {
                arrayDeque.add(node.left!!)
            }
            if (node.right != null) {
                arrayDeque.add(node.right!!)
            }
        }

        if (rootA == null) {
            return false
        }

        arrayDeque.clear()
        arrayDeque.add(rootA)

        while (arrayDeque.isNotEmpty() && arrayBQueue.isNotEmpty()) {
            val nodeA = arrayDeque.removeFirst()
            val nodeB = arrayBQueue.removeFirst()

            if (nodeA.`val` != nodeB.`val`) {
                return false
            }

            if (nodeA.left != null) {
                if (nodeB.left != null) {
                    arrayDeque.add(nodeA.left!!)
                    arrayBQueue.add(nodeB.left!!)
                }
            } else {
                if (nodeB.left != null) {
                    return false
                }
            }

            if (nodeA.right != null) {
                if (nodeB.right != null) {
                    arrayDeque.add(nodeA.right!!)
                    arrayBQueue.add(nodeB.right!!)
                }
            } else {
                if (nodeB.right != null) {
                    return false
                }
            }

        }

        return arrayBQueue.isEmpty()

    }
}


