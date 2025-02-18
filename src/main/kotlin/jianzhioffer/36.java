package jianzhioffer;

import java.util.ArrayList;

class Solution_36 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }



    private ArrayList<Node> list = new ArrayList<Node>();

    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }

        dfs(root);

        //构建双向链表
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            node.left = i == 0 ? list.getLast() : list.get(i - 1);
            node.right = i == list.size() - 1 ? list.getFirst() : list.get(i + 1);
        }

        return list.getFirst();
    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }
}