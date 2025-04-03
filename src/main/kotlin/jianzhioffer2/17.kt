package jianzhioffer2

import kotlin.math.pow

/**
 * 实现一个十进制数字报数程序，请按照数字从小到大的顺序返回一个整数数列，该数列从数字 1 开始，到最大的正整数 cnt 位数字结束。
 */

class Solution_17 {
    fun countNumbers(cnt: Int): IntArray {
        return IntArray(
            size = 10.0.pow(cnt.toDouble()).toInt()-1,
            init = {
                index->
                index+1
            }
        )
    }
}