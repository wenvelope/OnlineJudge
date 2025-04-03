package jianzhioffer2

import java.util.PriorityQueue
import javax.swing.text.html.HTML.Tag.P

/**
 * 科技馆内有一台虚拟观景望远镜，它可以用来观测特定纬度地区的地形情况。该纬度的海拔数据记于数组 heights ，
 * 其中 heights[i] 表示对应位置的海拔高度。请找出并返回望远镜视野范围 limit 内，可以观测到的最高海拔值。
 *
 *
 * 输入：heights = [14,2,27,-5,28,13,39], limit = 3
 * 输出：[27,27,28,28,39]
 * 解释：
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [14 2 27] -5 28 13 39          27
 * 14 [2 27 -5] 28 13 39          27
 * 14 2 [27 -5 28] 13 39          28
 * 14 2 27 [-5 28 13] 39          28
 * 14 2 27 -5 [28 13 39]          39
 */
class Solution_59_1 {
    fun maxAltitude(heights: IntArray, limit: Int): IntArray {
        //作弊 大顶堆
        val bigHeap = PriorityQueue<Int>(
            Comparator.reverseOrder()
        )

        val result = arrayListOf<Int>()


        if (heights.size == 1) {
            return intArrayOf(heights[0])
        }

        var leftPoint = 0
        var rightPoint = limit - 1

        for (index in 0..rightPoint) {
            bigHeap.add(heights[index])
        }

        //limit 范围>=1
        while (leftPoint <= rightPoint && rightPoint < heights.size) {
            result.add(bigHeap.peek())
            bigHeap.remove(heights[leftPoint])
            leftPoint++
            rightPoint++
            if (rightPoint < heights.size) {
                bigHeap.add(heights[rightPoint])
            } else {
                break
            }
        }

        return result.toIntArray()
    }
}
