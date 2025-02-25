package jianzhioffer

import kotlin.math.max

/**
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/description/
 *
 * 珠宝的最高价值
 *
 */

class Solution_47 {


    fun jewelleryValue(frame: Array<IntArray>): Int {
        val dp = Array(frame.size) { IntArray(frame[0].size) }
        for (i in 0..<frame.size) {
            for (j in 0..<frame[i].size) {
                if (i == 0 && j == 0) {
                    dp[i][j] = frame[i][j]
                    continue
                }

                if (i - 1 < 0) {
                    dp[i][j] = dp[i][j - 1] + frame[i][j]
                    continue
                }

                if (j - 1 < 0) {
                    dp[i][j] = dp[i - 1][j] + frame[i][j]
                    continue
                }


                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + frame[i][j]


            }
        }
        return dp[frame.size - 1][frame[0].size - 1]
    }
}


fun main() {
    val dp = arrayOf<IntArray>(IntArray(40))
    println(dp.size)

}

