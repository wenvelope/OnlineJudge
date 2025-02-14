package jianzhioffer;


import java.util.Stack;

class Solution_52 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode cur = headA;
        while (cur != null) {
            stackA.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            stackB.add(cur);
            cur = cur.next;
        }

        if (stackA.isEmpty()||stackB.isEmpty()){
            return null;
        }


        if (!(stackA.peek() == stackB.peek())){
            return null;
        }

        ListNode pre = null;

        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode aNode = stackA.pop();
            ListNode bNode = stackB.pop();
            if (aNode == bNode){
                pre = aNode;
            }else {
                return pre;
            }
        }

        return pre;

    }
}