package jianzhioffer


/**
 *
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/submissions/599568193/
 */
class Solution_54 {


    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun findTargetNode(root: TreeNode?, cnt: Int): Int {
        val list = mutableListOf<Int>()
        dfs(root, list)
        return list[list.size - cnt]
    }

    fun dfs(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) {
            return
        }
        dfs(root.left, list)
        list.add(root.`val`)
        dfs(root.right, list)
    }
}