package jianzhioffer;


class Solution_18 {
    public class ListNode {
        int val;
        Solution_18.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, Solution_18.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode curNode = head.next;
        ListNode preNode = head;
        while (curNode!= null && curNode.val!=val){
           curNode = curNode.next;
           preNode = preNode.next;
        }
        if (curNode != null) {
            preNode.next = curNode.next;
            curNode.next = null;
        }
        return head;

    }
}