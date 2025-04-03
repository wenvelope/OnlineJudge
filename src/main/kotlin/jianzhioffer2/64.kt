package jianzhioffer2

/**
 * 请设计一个机械累加器，计算从 1、2... 一直累加到目标数值 target 的总和。
 * 注意这是一个只能进行加法操作的程序，不具备乘除、if-else、switch-case、for 循环、while 循环，及条件判断语句等高级功能。
 *
 *
 * 输入: target = 5
 * 输出: 15
 */

class Solution_64 {
    var sum = 0
    fun mechanicalAccumulator(target: Int): Int {
        return add(target)
    }

    fun add(target: Int): Int {
        target > 1 && add(target - 1) > 0
        sum += target
        return sum
    }
}