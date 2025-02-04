package jianzhioffer

import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.index

/**
 * https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/description/
 */
class Solution_39 {
    fun inventoryManagement(stock: IntArray): Int {
        var majority = stock[0]
        var count = 1
        for (i in 1 until stock.size) {
            if (majority == stock[i]) {
                count++
            } else {
                count--
            }
            if (count == 0) {
                majority = stock[i]
                count = 1
            }
        }

        return if (count >= 0) {
            majority
        } else {
            -1
        }
    }
}

fun main() {
    val s = Solution_39()
    println(s.inventoryManagement(intArrayOf(6, 1, 3, 1, 1, 1)))
}