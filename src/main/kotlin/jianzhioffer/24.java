package jianzhioffer;

/**
 * 给定一个头节点为 head 的单链表用于记录一系列核心肌群训练编号，请将该系列训练编号 倒序 记录于链表并返回。
 *
 * 双指针
 *
 */
class Solution_24 {

    public class ListNode {
        int val;
        Solution_24.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, Solution_24.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode trainningPlan(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }
        return cur;
    }
}
