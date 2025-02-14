package jianzhioffer

import java.util.LinkedList


/**
 *
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */
class Solution_32_3 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


    fun decorateRecord(root: TreeNode?): List<List<Int>> {
        val queue = LinkedList<Pair<Int, TreeNode>>()
        if (root == null) {
            return emptyList()
        }

        queue.add(0 to root)
        val resultArrayList = mutableListOf<ArrayDeque<Int>>()

        while (queue.isNotEmpty()) {
            val pair = queue.poll()
            val index = pair.first
            val node = pair.second

            if (resultArrayList.size <= index) {
                resultArrayList.add( ArrayDeque<Int>())
            }

            if (index % 2 == 0) {
                resultArrayList[index].add(node.`val`)
            } else {
                resultArrayList[index].addFirst(node.`val`)
            }



            if (node.left != null) {
                queue.add(index + 1 to node.left!!)
            }
            if (node.right != null) {
                queue.add(index + 1 to node.right!!)
            }
        }

        return resultArrayList
    }
}