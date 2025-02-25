package jianzhioffer

import kotlin.math.max


/**
 * 某公司每日销售额记于整数数组 sales，请返回所有 连续 一或多天销售额总和的最大值。
 *
 * 要求实现时间复杂度为 O(n) 的算法。
 *
 * https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/description/
 */
class Solution {
    fun maxSales(sales: IntArray): Int {
        val dp = IntArray(sales.size)
        dp[0] = sales[0]
        var max = dp[0]
        for (i in 1..<sales.size) {
            if (dp[i - 1] < 0) {
                dp[i] = sales[i]
            } else {
                dp[i] = dp[i - 1] + sales[i]
            }
            max = max(max, dp[i])
        }
        return max
    }
}