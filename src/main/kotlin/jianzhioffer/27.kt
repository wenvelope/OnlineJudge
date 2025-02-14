package jianzhioffer

class Solution_27{

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


    fun flipTree(root: TreeNode?): TreeNode? {
        reverseTree(root)
        return root
    }

    fun reverseTree(root: TreeNode?){
        if (root == null){
            return
        }

        val temp = root.left
        root.left = root.right
        root.right = temp

        reverseTree(root.left)
        reverseTree(root.right)
    }
}