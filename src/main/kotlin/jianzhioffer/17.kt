package jianzhioffer

import kotlin.math.pow


/**
 * 实现一个十进制数字报数程序，请按照数字从小到大的顺序返回一个整数数列，该数列从数字 1 开始，到最大的正整数 cnt 位数字结束。
 * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/description/
 */
class Solution_17 {
    fun countNumbers(cnt: Int): IntArray {
        val size = 10.0.pow(cnt).toInt() - 1
        val array = IntArray(size)
        for (i in 0 until size) {
            array[i] = i + 1
        }
        return array
    }
}