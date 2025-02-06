package jianzhioffer

/**
 * 剑指offer57-II.和为s的连续正数序列。
 *https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/description/
 *
 */

class Solution_57_2 {
    fun fileCombination(target: Int): Array<IntArray> {
        return slidingWindow(target)
    }

    fun slidingWindow(target: Int): Array<IntArray> {
        var left = 1
        var right = 2

        val result = arrayListOf<IntArray>()

        while (left <= target / 2) {
            val sum = (left + right) * (right - left + 1) / 2
            if (sum == target) {
                val targetList = IntArray(right - left + 1) { index ->
                    index + left
                }
                result.add(targetList)
                right++
            } else if (sum > target) {
                if (right - left + 1 <= 2) {
                    right++
                } else {
                    left++
                }
            } else {
                right++
            }
        }
        return result.toTypedArray()

    }
}