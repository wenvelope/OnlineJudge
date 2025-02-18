package jianzhioffer

import kotlin.math.max


/**
 * https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/description/
 */
class Solution_55_1 {


    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun calculateDepth(root: TreeNode?): Int {

        return dfs(root, 0, 0) + 1

    }

    fun dfs(root: TreeNode?, depth: Int, maxDepth: Int): Int {
        if (root == null) {
            return max(maxDepth, depth)
        }
        val left = dfs(root.left, depth + 1, maxDepth)
        val right = dfs(root.right, depth + 1, maxDepth)
        return maxOf(left, right)
    }
}