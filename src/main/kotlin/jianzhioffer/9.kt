package jianzhioffer

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

class Solution_9 {

    val queue = LinkedList<Int>()

    fun appendTail(value: Int) {
        queue.add(value)
    }

    fun deleteHead(): Int {
        return queue.poll() ?: -1
    }
}