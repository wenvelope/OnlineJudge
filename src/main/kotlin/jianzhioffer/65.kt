package jianzhioffer


/**
 * https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/description/
 *
 * 不用运算符实现加法
 */
class Solution_65{
    fun encryptionCalculate(dataA: Int, dataB: Int): Int {
        //加法可以分为 无进位和 与 进位和
        //无进位和可以通过异或运算得到
        //进位和可以通过与运算 左移一位得到
        //此题目不考虑溢出
        var a = dataA
        var b = dataB
        while (b!=0){
            val temp = a xor b
            b = a and b shl 1
            a = temp
        }
        return a
    }
}