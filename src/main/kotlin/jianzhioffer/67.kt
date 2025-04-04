package jianzhioffer

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 */
class Solution_67 {
    fun myAtoi(str: String): Int {
        if (str.isEmpty()) return 0

        // 1、去除前导空格
        var index = 0
        while (index < str.length && str[index] == ' ') index++
        // 如果已经遍历完成（针对极端用例 "      "）
        if (index == str.length) return 0

        // 2、处理正负号：如果出现符号字符，仅第1个有效，并记录正负
        var sign = 1
        val firstChar = str[index]
        if (firstChar == '+') {
            index++
        } else if (firstChar == '-') {
            index++
            sign = -1
        }

        // 3、从后续出现的数字字符中取出当前数字，在进行进制转换，注意不合法的情况
        var total = 0
        while (index < str.length) {
            // 3.1 取出当前数字
            val digit = str[index] - '0'
            // 3.2 先判断不合法的情况
            if (digit < 0 || digit > 9) break

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判断乘以 10 以后是否越界
            if (total > Int.MAX_VALUE / 10 || (total == Int.MAX_VALUE / 10 && digit > Int.MAX_VALUE % 10)) {
                return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
            }

            // 3.3 合法的情况下，才考虑转换
            total = 10 * total + digit
            index++
        }

        // 3.4 最后，把符号位乘进去
        return total * sign
    }
}