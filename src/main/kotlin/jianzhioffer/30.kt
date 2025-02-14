package jianzhioffer

import java.util.PriorityQueue
import java.util.Stack
import kotlin.math.min

class Solution_30 {

    /** initialize your data structure here. */

    val stack = Stack<Int>()
    val priorityQueue = PriorityQueue<Int>()

    fun push(x: Int) {
        stack.push(x)
        priorityQueue.add(x)
    }

    fun pop() {
        val x = stack.pop()
        priorityQueue.remove(x)
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
       return priorityQueue.peek()
    }
}