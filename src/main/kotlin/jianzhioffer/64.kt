package jianzhioffer

/**
 * https://leetcode.cn/problems/qiu-12n-lcof/description/
 */
class Solution_64 {
    private var sum = 0
    fun mechanicalAccumulator(target: Int): Int {
        return sum(target)
    }

    fun sum(currentNum: Int): Int {
        currentNum > 1 && (sum(currentNum - 1) >= 0)
        sum += currentNum
        return sum
    }
}