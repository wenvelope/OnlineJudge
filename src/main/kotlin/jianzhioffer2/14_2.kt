package jianzhioffer2

import java.math.BigDecimal
import kotlin.math.max

/**
 * 现需要将一根长为正整数 bamboo_len 的竹子砍为若干段，每段长度均为 正整数。请返回每段竹子长度的 最大乘积 是多少。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */

class Solution_14_2 {
    fun cuttingBamboo(bamboo_len: Int): Int {
        if (bamboo_len <= 3) {
            return bamboo_len - 1
        }
        val P = 1e9 + 7L
        when (bamboo_len % 3) {
            0 -> {
                val times = bamboo_len / 3L
                return remainder(3, times, P.toLong()).toInt()
            }

            1 -> {
                val times = bamboo_len / 3L
                return remainder(3, times - 1, P.toLong()).toInt() * 4

            }

            else -> {
                val times = bamboo_len / 3L
                return remainder(3, times, P.toLong()).toInt() * 2
            }
        }
    }

    fun remainder(base: Long, exp: Long, mod: Long): Long {
        var res = 1L
        var b = base % mod
        var e = exp

        while (e > 0) {
            if (e and 1L == 1L) {  // 如果当前位是 1，则乘入结果
                res = (res * b) % mod
            }
            b = (b * b) % mod  // 平方底数
            e = e shr 1       // 指数右移一位
        }

        return res
    }
}