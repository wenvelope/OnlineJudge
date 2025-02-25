package jianzhioffer

import java.util.Stack
import kotlin.math.pow

/**
 * https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/solutions/637778/jian-zhi-offer-60-n-ge-tou-zi-de-dian-sh-z36d/
 *
 * 你选择掷出 num 个色子，请返回所有点数总和的概率。
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 num 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 */
class Solution60 {
    fun statisticsProbability(num: Int): DoubleArray {
        var dp = DoubleArray(6) { 1.0 / 6 }
        for (i in 2..num) {
            val temp = DoubleArray(5 * i + 1)
            for (j in 0 until dp.size) {
                for (k in 0 until 6) {
                    temp[j + k] += dp[j] / 6
                }
            }
            dp = temp
        }
        return dp
    }


}

fun main() {
    val solution60 = Solution60()
    val result = solution60.statisticsProbability(2)
}

