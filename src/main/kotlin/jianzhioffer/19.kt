package jianzhioffer


/**
 * https://leetcode.cn/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 */
class Solution_19 {
    fun articleMatch(s: String, p: String): Boolean {
        val dp = Array(s.length + 1) { BooleanArray(p.length + 1) }
        dp[0][0] = true
        for (i in 0..s.length) {
            for (j in 1..p.length) {
                dp[i][j] = if (j >= 2 && p[j - 1] == '*') {
                    dp[i][j - 2] || i > 0 && dp[i - 1][j] && (s[i - 1] == p[j - 2] || p[j - 2] == '.')
                } else {
                    i > 0 && dp[i - 1][j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '.')
                }

            }
        }
        return dp[s.length][p.length]
    }
}