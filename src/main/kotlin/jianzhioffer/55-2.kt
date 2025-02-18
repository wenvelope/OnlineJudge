package jianzhioffer

import kotlin.math.abs


/**
 * https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/
 */
class Solution_55_2 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private var isBalanced = true

    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        // 判断左右字数的深度差是否大于1
        dfs(root, 0)
        return isBalanced
    }

    fun dfs(root: TreeNode?, depth: Int): Int {
        if (root == null) {
            return depth - 1
        }
        val leftDepth = dfs(root.left, depth + 1)
        val rightDepth = dfs(root.right, depth + 1)
        if (abs(leftDepth - rightDepth) > 1) {
            isBalanced = false
        }
        return maxOf(leftDepth, rightDepth)
    }


}