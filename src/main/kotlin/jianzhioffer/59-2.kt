package jianzhioffer

import java.util.Comparator
import java.util.LinkedList
import java.util.PriorityQueue

class Solution_59_2 {

    val queue = LinkedList<Int>()
    val priorityQueue = PriorityQueue<Int>(
        Comparator.reverseOrder<Int>()
    )

    fun get_max(): Int {
        return priorityQueue.peek() ?: -1
    }

    fun add(value: Int) {
        queue.add(value)
        priorityQueue.add(value)
    }

    fun remove(): Int {
        if (queue.isEmpty()){
            return -1
        }else{
            val num = queue.pop()
            priorityQueue.remove(num)
            return num
        }
    }
}