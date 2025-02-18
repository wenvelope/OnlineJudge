package jianzhioffer

/**
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/description/
 */

class Solution_56_1 {
    fun sockCollocation(sockets: IntArray): IntArray {
        // 1. 先计算所有元素的异或值
        var xor = 0
        for (socket in sockets) {
            xor = xor xor socket
        }
        // 2. 找到异或值中第一个为1的位
        var mask = 1
        while (xor and mask == 0) {
            mask = mask shl 1
        }
        // 3. 根据这个位将数组分为两部分
        var a = 0
        var b = 0
        for (socket in sockets) {
            if (socket and mask == 0) {
                a = a xor socket
            } else {
                b = b xor socket
            }
        }
        return intArrayOf(a, b)
    }
}