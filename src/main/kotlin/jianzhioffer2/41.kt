package jianzhioffer2

import java.util.*

class MedianFinder() {

    /** initialize your data structure here. */
    private val smallHeap = PriorityQueue<Int>(

    )
    private val bigHeap = PriorityQueue<Int>(
        Comparator.reverseOrder()
    )

    fun addNum(num: Int) {
        if (bigHeap.size > smallHeap.size) {
            //要插入数据到smallHeap
            //判断数据是否是大于大根堆所有值
            if (num > bigHeap.peek()) {
                //直接插入
                smallHeap.add(num)
            } else {
                //插入大根堆 替换大根堆最大值
                val temp = bigHeap.poll()
                bigHeap.add(num)
                smallHeap.add(temp)
            }
        } else {
            // 要插入数据到bigHeap
            //判断是否小于小根堆所有值
            if (smallHeap.isEmpty() || num < smallHeap.peek()) {
                bigHeap.add(num)
            }else{
                val temp = smallHeap.poll()
                smallHeap.add(num)
                bigHeap.add(temp)
            }
        }
    }

    fun findMedian(): Double {
        return if (smallHeap.size == bigHeap.size) {
            (smallHeap.peek() + bigHeap.peek()) / 2.0
        } else {
            if (smallHeap.size > bigHeap.size) {
                smallHeap.peek().toDouble()
            } else {
                bigHeap.peek().toDouble()
            }
        }
    }

}