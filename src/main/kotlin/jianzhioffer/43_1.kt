package jianzhioffer

/**
 * https://leetcode.cn/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/description/
 */
class Solution_43_1{
    fun digitOneInNumber(num: Int): Int {
        var count = 0
        var i = 1
        var high = num / 10
        var cur = num % 10
        var low = 0
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                count += high * i
            } else if (cur == 1) {
                count += high * i + low + 1
            } else {
                count += (high + 1) * i
            }
            low += cur * i
            cur = high % 10
            high /= 10
            i *= 10
        }
        return count
    }
}