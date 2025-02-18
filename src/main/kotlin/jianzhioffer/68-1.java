package jianzhioffer;


import java.util.ArrayList;

/**
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/description/
 */
class Solution_68_1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pPath = new ArrayList<>();
        ArrayList<TreeNode> qPath = new ArrayList<>();

        TreeNode pPointer = root;
        TreeNode qPointer = root;

        boolean pFound = false;
        boolean qFound = false;

        while (!pFound || !qFound) {
            if (!pFound){
                pPath.add(pPointer);
                if (pPointer.val == p.val) {
                    pFound = true;
                } else if (pPointer.val > p.val) {
                    pPointer = pPointer.left;
                } else {
                    pPointer = pPointer.right;
                }
            }

            if (!qFound){
                qPath.add(qPointer);
                if (qPointer.val == q.val) {
                    qFound = true;
                } else if (qPointer.val > q.val) {
                    qPointer = qPointer.left;
                } else {
                    qPointer = qPointer.right;
                }
            }
        }

        int pIndex = pPath.size() - 1;
        int qIndex = qPath.size() - 1;

        if (pIndex >= qIndex){
            for(int i = qIndex; i >= 0; i--){
                if (pPath.contains(qPath.get(i))){
                    return qPath.get(i);
                }
            }
        }else {
            for(int i = pIndex; i >= 0; i--){
                if (qPath.contains(pPath.get(i))){
                    return pPath.get(i);
                }
            }
        }

        return null;
    }
}