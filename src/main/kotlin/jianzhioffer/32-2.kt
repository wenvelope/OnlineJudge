package jianzhioffer

import java.util.LinkedList


/**
 *
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 */
class Solution_32_2{

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


    fun decorateRecord(root: Solution_32_1.TreeNode?):  List<List<Int>> {
        val queue = LinkedList<Pair<Int, Solution_32_1.TreeNode>>()
        if (root == null) {
            return emptyList()
        }

        queue.add(0 to root)
        val resultArrayList = mutableListOf<MutableList<Int>>()

        while (queue.isNotEmpty()) {
            val pair = queue.poll()
            val index = pair.first
            val node = pair.second

            if (resultArrayList.size <= index) {
                resultArrayList.add(mutableListOf<Int>())
            }

            resultArrayList[index].add(node.`val`)

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