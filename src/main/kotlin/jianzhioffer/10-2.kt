package jianzhioffer

/**
 * https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/description/
 *
 *
 */
class Solution_10_2 {
    fun trainWays(num: Int): Int {
        if (num == 0) return 1
        if (num == 1) return 1
        val dp = IntArray(num + 1)
        dp[0] = 1
        dp[1] = 1
        dp[2] = 2
        for (i in 3..num) {
            //前两台阶的最多种类+1 或者 前一台阶的最多种类+1
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007
        }
        return dp[num]
    }
}