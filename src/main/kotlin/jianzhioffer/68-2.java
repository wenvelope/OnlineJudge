package jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
class Solution_68_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    TreeNode result;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        result = null;
        //中序遍历结果
        dfs(root, p, q);
        return result;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean isLeft = dfs(root.left, p, q);
        boolean isRight = dfs(root.right, p, q);
        if ((isLeft && isRight) || ((root.val == p.val || root.val == q.val) && (isLeft || isRight))) {
            result = root;
        }
        return isLeft || isRight || (root.val == p.val || root.val == q.val);

    }


}