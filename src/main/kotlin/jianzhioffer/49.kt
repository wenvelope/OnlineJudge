package jianzhioffer

import kotlin.math.min

/**
 *
 * 丑数
 * （为什么2 3 5 就是丑
 *
 * https://leetcode.cn/problems/chou-shu-lcof/description/
 */
class Solution_49 {
    fun nthUglyNumber(n: Int): Int {
        val dp: IntArray = IntArray(n)
        if (n <= 6) {
            return n
        }
        dp[0] = 1
        var index2 = 0
        var index3 = 0
        var index5 = 0
        for (i in 1 until n) {
            val next2 = dp[index2] * 2
            val next3 = dp[index3] * 3
            val next5 = dp[index5] * 5
            val nextNum = min(next2, min(next3, next5))

            dp[i] = nextNum

            if (nextNum == next2) {
                index2++
            }

            if (nextNum == next3) {
                index3++
            }

            if (nextNum == next5) {
                index5++
            }
        }
        return dp[n - 1]
    }
}