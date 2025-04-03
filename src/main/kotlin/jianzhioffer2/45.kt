package jianzhioffer2

import java.io.File.separator
import java.util.PriorityQueue

/**
 *闯关游戏需要破解一组密码，闯关组给出的有关密码的线索是：
 *
 * 一个拥有密码所有元素的非负整数数组 password
 * 密码是 password 中所有元素拼接后得到的最小的一个数
 * 请编写一个程序返回这个密码。
 *
 *
 * 输入：password = [15, 8, 7]
 * 输出："1578"
 *
 */

class Solution_45 {
    fun crackPassword(password: IntArray): String {
        return password.map {
            it.toString()
        }.sortedWith { a, b ->
            (a + b).compareTo(b + a)
        }.joinToString(separator = "")
    }
}