package jianzhioffer

import java.util.LinkedList
import kotlin.collections.isNotEmpty

/**
 * 一棵圣诞树记作根节点为 root 的二叉树，节点值为该位置装饰彩灯的颜色编号。请按照从 左 到 右 的顺序返回每一层彩灯编号。
 *
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/description/
 */
class Solution_32_1 {


    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun decorateRecord(root: TreeNode?): IntArray {
        val queue = LinkedList<TreeNode>()
        if (root == null) {
            return intArrayOf()
        }

        queue.add(root)
        val arrayList = mutableListOf<Int>()

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            arrayList.add(node.`val`)

            if (node.left != null) {
                queue.add(node.left!!)
            }
            if (node.right != null) {
                queue.add(node.right!!)
            }
        }

        return arrayList.toIntArray()
    }
}