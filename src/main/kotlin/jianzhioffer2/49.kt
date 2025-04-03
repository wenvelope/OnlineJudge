package jianzhioffer2

import java.util.PriorityQueue
import kotlin.math.min


/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 说明：丑数是只包含质因数 2、3 和/或 5 的正整数；1 是丑数。
 *
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
class Solution_49 {
    fun nthUglyNumber(n: Int): Int {
        val set = HashSet<Long>()
        val smallHeap = PriorityQueue<Long>()
        val factors = listOf(2, 3, 5)
        set.add(1L)
        var result = 1L
        smallHeap.add(1L)
        for (index in 1..n) {
            val curren = smallHeap.poll()
            result = curren
            factors.forEach {
                val next = curren * it
                if (set.add(next)) {
                    smallHeap.add(next)
                }
            }
        }
        return result.toInt()
    }

    fun nthUglyNumberDp(n: Int): Int {
        var point2 = 1
        var point3 = 1
        var point5 = 1
        val dp = IntArray(n + 1)
        dp[1] = 1
        for (index in 2..n) {
            val numP2 = dp[point2] * 2
            val numP3 = dp[point3] * 3
            val numP5 = dp[point5] * 5
            val minNum = min(numP2, min(numP3, numP5))
            dp[index] = minNum
            if (minNum == numP2) {
                point2++
            }
            if (minNum == numP3) {
                point3++
            }
            if (minNum == numP5) {
                point5++
            }
        }
        return dp[n]
    }
}