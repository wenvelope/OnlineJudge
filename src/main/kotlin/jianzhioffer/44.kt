package jianzhioffer


/**
 * https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 */
internal class Solution_44 {
    fun findKthNumber(k: Int): Int {
        var k = k
        var digit = 1
        var start: Long = 1
        var count: Long = 9
        while (k > count) { // 1.
            k -= count.toInt()
            start *= 10
            digit += 1
            count = digit * start * 9
        }
        val num = start + (k - 1) / digit // 2.
        return num.toString()[(k - 1) % digit].code - '0'.code // 3.
    }
}