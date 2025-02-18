package jianzhioffer


class Solution_34_1 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    //回溯法
    fun pathTarget(root: TreeNode?, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        dfs(root, target, path, result)
        return result
    }

    fun dfs(root: TreeNode?, target: Int, path: MutableList<Int>, result: MutableList<List<Int>>) {
        if (root == null) {
            return
        }
        path.add(root.`val`)
        dfs(root.left, target, path, result)
        dfs(root.right, target, path, result)
        if (path.sumOf { it } == target && root.left == null && root.right == null) {
            result.add(arrayListOf<Int>().apply {
                addAll(path)
            })
        }
        path.removeLast()


    }
}