package jianzhioffer

import java.util.Comparator
import java.util.PriorityQueue

/**
 *
 * 剑指offer41.数组流中的中位数
 *
 * https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/description/
 *
 * 优先队列
 */
class Solution_41 {
    /** initialize your data structure here. */
    //小顶堆
    private val littleHeap = PriorityQueue<Int>()

    //大顶堆
    private val bigHeap = PriorityQueue<Int>(
        Comparator.reverseOrder<Int>()
    )

    private val distance: Int
        get() {
            return bigHeap.size - littleHeap.size
        }

    fun addNum(num: Int) {

        if (littleHeap.isEmpty()) {
            littleHeap.add(num)
            return
        }

        if (num < littleHeap.peek()) {
            bigHeap.add(num)
        } else {
            littleHeap.add(num)
        }

        if (distance > 1) {
            val num = bigHeap.poll()
            littleHeap.add(num)
            return
        }

        if (distance < -1) {
            val num = littleHeap.poll()
            bigHeap.add(num)
            return
        }
    }

    fun findMedian(): Double {
        return if (distance == 1) {
            bigHeap.peek().toDouble()
        } else if (distance == -1) {
            littleHeap.peek().toDouble()
        } else {
            (bigHeap.peek() + littleHeap.peek()) / 2.0
        }
    }

}

fun main() {
    val so = Solution_41()
    so.apply {
        addNum(1)
        addNum(2)
        val x = findMedian()
        println(x)
    }
}