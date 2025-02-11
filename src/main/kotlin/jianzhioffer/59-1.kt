package jianzhioffer

import java.util.Comparator
import java.util.PriorityQueue

/**
 * https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/submissions/597091135/
 */
class Solution_59_1 {
    fun maxAltitude(heights: IntArray, limit: Int): IntArray {
        val result = arrayListOf<Int>()
        var left = 0
        var right = left + limit - 1
        val buffer = PriorityQueue<Int>(
            Comparator.reverseOrder<Int>()
        )

        for (i in left..right) {
            buffer.add(heights[i])
        }

        while (right < heights.size && right >= 0) {
            val max = buffer.peek()
            result.add(max)

            buffer.remove(heights[left])
            left++

            right++

            if (right < heights.size) {
                buffer.add(heights[right])
            }

        }
        return result.toIntArray()
    }
}