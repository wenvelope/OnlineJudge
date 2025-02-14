package jianzhioffer;


/**
 *
 *
 * 剑指offer25.合并两个排序的链表。
 *
 *
 * https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/description/
 *
 *
 *
 */
class Solution_25 {
    public class ListNode {
        int val;
        Solution_25.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, Solution_25.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        ListNode leftPoint = l1;
        ListNode rightPoint = l2;
        ListNode head = null;
        ListNode newCur = null;
        while (leftPoint != null && rightPoint != null) {
            if (leftPoint.val < rightPoint.val) {
                //创建头
                if (head == null) {
                    head = leftPoint;
                    newCur = head;
                } else {
                    // 有头的时候
                    newCur.next = leftPoint;
                    newCur = leftPoint;
                }

                leftPoint = leftPoint.next;

            } else {
                if (head == null) {
                    head = rightPoint;
                    newCur = head;
                } else {
                    //有头的时候
                    newCur.next = rightPoint;
                    newCur = rightPoint;
                }

                rightPoint = rightPoint.next;
            }
        }

        while (leftPoint != null) {

            if (head == null) {
                head = leftPoint;
                newCur = head;
            } else {
                // 有头的时候
                newCur.next = leftPoint;
                newCur = leftPoint;
            }

            leftPoint = leftPoint.next;
        }

        while (rightPoint != null) {
            if (head == null) {
                head = rightPoint;
                newCur = head;
            } else {
                //有头的时候
                newCur.next = rightPoint;
                newCur = rightPoint;
            }

            rightPoint = rightPoint.next;
        }

        return head;


    }
}