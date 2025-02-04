package jianzhioffer

import kotlin.math.max
import kotlin.math.pow


/**
 *
 * 14-1 剪绳子。
 *
 * 现需要将一根长为正整数 bamboo_len 的竹子砍为若干段，每段长度均为正整数。请返回每段竹子长度的最大乘积是多少。
 *
 */
class Solution_14_1 {
    fun cuttingBamboo(bamboo_len: Int): Int {
        when (bamboo_len) {
            1 -> {
                return 0
            }

            2 -> {
                return 1
            }

            3 -> {
                return 2
            }

            else -> {
                var timesOf3 = bamboo_len / 3
                if (bamboo_len - timesOf3 * 3 == 1) {
                    timesOf3--
                }
                val timesOf2 = (bamboo_len - timesOf3 * 3) / 2
                return (3.0.pow(timesOf3) * 2.0.pow(timesOf2).toInt()).toInt()
            }
        }
    }

}


class Solution14_2 {
    fun cuttingBamboo(bamboo_len: Int): Int {
        //dp解法
        val maxList = IntArray(bamboo_len + 1)
        maxList[1] = 1
        maxList[2] = 1
        for (i in 1..bamboo_len) {
            for (j in 1 until i) {
                maxList[i] = max(maxList[i], max(j * (i - j), j * maxList[i - j]))
            }
        }
        return maxList[bamboo_len]
    }
}

fun main() {
    val sa = Solution_14_1()
    println(sa.cuttingBamboo(48))
}