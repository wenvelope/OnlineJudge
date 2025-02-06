package jianzhioffer

/**
 *
 * https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/description/
 *
 *  查找总价格为目标值的两个商品
 *
 */
class Solution_57_1 {
    fun twoSum(price: IntArray, target: Int): IntArray {
        return selectTarget(price, target)
    }

    fun selectTarget(price: IntArray, target: Int): IntArray {
        var left = 0
        var right = price.size - 1
        while (left < right) {
            if (price[left] + price[right] > target) {
                right--
            } else if (price[left] + price[right] < target) {
                left++
            } else {
                return intArrayOf(price[left], price[right])
            }
        }
        return intArrayOf()
    }
}