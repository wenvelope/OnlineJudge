package jianzhioffer2

import kotlin.math.max

/**
 * 现需要将一根长为正整数 bamboo_len 的竹子砍为若干段，每段长度均为正整数。请返回每段竹子长度的最大乘积是多少。
 *
 *
 *
 * 输入: bamboo_len = 12
 * 输出: 81
 */
class Solution_14_1 {
    fun cuttingBamboo(bamboo_len: Int): Int {
        val maxList = IntArray(bamboo_len+1)
        maxList[1] = 1
        maxList[2] = 1
        for (i in 1..maxList.lastIndex){
            for (j in 1..<i){
                maxList[i] = max(maxList[i], max(j*(i-j),j* maxList[i-j]))
            }
        }
        return maxList[bamboo_len]
    }
}