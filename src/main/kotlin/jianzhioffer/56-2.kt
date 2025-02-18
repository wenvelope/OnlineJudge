package jianzhioffer


/**
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * 一个整型数组里除了两个数字之外，其他的数字都出现了三次。
 */
class Solution_56_2 {
    fun trainingPlan(actions: IntArray): Int {
        var ones = 0
        var twos = 0
        for (action in actions) {
            ones = ones xor action and twos.inv()
            twos = twos xor action and ones.inv()
        }
        return ones
    }
}