package jianzhioffer


/**
 * https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 *
 *
 * 快速幂算法
 */
class Solution_16 {
    fun myPow(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }
        val N = n.toLong()
        return if (N > 0) {
            quick(x, N)
        } else {
            1 / quick(x, -N)
        }
    }

    fun quick(x: Double, n: Long): Double {
        if (n == 0L) {
            return 1.0
        }
        val y = quick(x, n.shr(1))
        return if (n % 2 == 0L) {
            y * y
        } else {
            y * y * x
        }
    }
}