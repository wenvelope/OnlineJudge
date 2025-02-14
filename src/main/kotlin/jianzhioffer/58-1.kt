package jianzhioffer


/**
 *
 * https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
class Solution_58_1 {
    fun reverseMessage(message: String): String {
        val messageList = message.trim().split(delimiters = arrayOf(" ")).filter { it != "" }
        return messageList.reversed().joinToString(" ")
    }
}

fun main() {
    val s = Solution_58_1()
    println(s.reverseMessage("a good   example"))
}