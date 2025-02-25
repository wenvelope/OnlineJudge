package jianzhioffer

/**
 * https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/description/
 */
class Solution_46 {
    fun crackNumber(ciphertext: Int): Int {
        val text = ciphertext.toString()
        val dp = IntArray(text.length)
        dp[0] = 1
        for (index in 2..text.length) {
            val num = text.substring(index - 2, index).toInt()
            if (num in 10..25) {
                dp[index - 1] = dp[index - 2] + if (index == 2) 1 else dp[index - 3]
            } else {
                dp[index - 1] = dp[index - 2]
            }
        }
        return dp[text.length - 1]

    }
}