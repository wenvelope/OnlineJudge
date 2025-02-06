package jianzhioffer


/**
 *
 *
 * 剑指offer45.把数组排成最小的数。
 *
 *https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 *
 */
class Solution_45 {
    fun crackPassword(password: IntArray): String {
        // 将整数数组转换为字符串数组
        val strArray = password.map { it.toString() }

        // 自定义排序规则：比较两个字符串拼接后的结果
        val sortedArray = strArray.sortedWith { a, b ->
            (a + b).compareTo(b + a)
        }

        // 拼接排序后的字符串
        val result = sortedArray.joinToString(separator = "")
        return result
    }
}