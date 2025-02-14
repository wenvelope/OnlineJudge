package jianzhioffer

import java.util.Stack


/**
 *
 * https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/description/
 *
 */
class Solution_31 {
    fun validateBookSequences(putIn: IntArray, takeOut: IntArray): Boolean {
        var leftPoint = 0
        var rightPoint = 0
        val stack = Stack<Int>()

        while (leftPoint < putIn.size && rightPoint < takeOut.size) {
            //先看能不能pop
            while(!stack.isEmpty() && stack.peek() == takeOut[rightPoint]) {
                stack.pop()
                rightPoint++
            }

            stack.push(putIn[leftPoint])
            leftPoint++

            //再看能不能pop
            while(!stack.isEmpty() && stack.peek() == takeOut[rightPoint]) {
                stack.pop()
                rightPoint++
            }
        }

        while (rightPoint < takeOut.size) {
            if (stack.peek() == takeOut[rightPoint]) {
                stack.pop()
                rightPoint++
            } else {
                return false
            }
        }

        return true

    }
}