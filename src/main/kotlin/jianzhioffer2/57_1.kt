package jianzhioffer2

/**
 * 购物车内的商品价格按照升序记录于数组 price。请在购物车中找到两个商品的价格总和刚好是 target。若存在多种情况，返回任一结果即可。
 *
 * 输入：price = [3, 9, 12, 15], target = 18
 * 输出：[3,15] 或者 [15,3]
 */

class Solution_57_1 {
    fun twoSum(price: IntArray, target: Int): IntArray {
        var pointLeft = 0
        var pointRight = price.size-1
        while (pointLeft < pointRight) {
            val sum = price[pointLeft] + price[pointRight]
            if (sum < target) {
                pointLeft++
            } else if (sum > target) {
                pointRight--
            } else {
                break
            }
        }
        return intArrayOf(price[pointLeft], price[pointRight])
    }
}