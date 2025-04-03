package jianzhioffer2

import java.util.Stack

/**
 * 书店店员有一张链表形式的书单，每个节点代表一本书，节点中的值表示书的编号。为更方便整理书架，店员需要将书单倒过来排列，就可以从最后一本书开始整理，逐一将书放回到书架上。请倒序返回这个书单链表。
 *
 * 输入：head = [3,6,4,1]
 *
 * 输出：[1,4,6,3]
 *
 */

class Solution_6 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseBookList(head: ListNode?): IntArray {
        val stack = Stack<ListNode>()
        var cur: ListNode? = head
        while (cur != null) {
            stack.push(cur)
            cur = cur.next
        }
        val result = IntArray(size = stack.size) { i: Int ->
            stack.pop().`val`
        }
        return result
    }
}