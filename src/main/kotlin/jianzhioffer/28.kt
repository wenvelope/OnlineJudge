package jianzhioffer


/**
 * https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 */
class Solution_28 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun checkSymmetricTree(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return  checkTwoTree(root.left, root.right)

    }

    fun checkTwoTree(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) {
            return true
        }

        if (left == null || right == null) {
            return false
        }

        if (left.`val` != right.`val`) {
            return false
        }

        return checkTwoTree(left.left, right.right) && checkTwoTree(right.left, left.right)

    }
}
