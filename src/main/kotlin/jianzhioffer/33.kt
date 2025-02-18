package jianzhioffer

import java.util.*

class Solution_33 {
    //    fun verifyTreeOrder(postorder: IntArray): Boolean {
//        val stack = Stack<Int>()
//        var root = Int.MAX_VALUE
//        for (i in postorder.size - 1 downTo 0) {
//            if (postorder[i] > root) {
//                return false
//            }
//            while (stack.isNotEmpty() && stack.peek() > postorder[i]) {
//                root = stack.pop()
//            }
//            stack.push(postorder[i])
//        }
//        return true
//    }
    fun verifyTreeOrder(postorder: IntArray): Boolean {
        if (postorder.isEmpty()) {
            return true
        }
        val indexedValue = postorder.withIndex().find { indexedValue: IndexedValue<Int> ->
            indexedValue.value > postorder.last()
        } ?: IndexedValue(postorder.size - 1, postorder.last())
        val leftTree = postorder.copyOfRange(0, indexedValue.index)

        val rightTree = if (indexedValue.index == postorder.size - 1) {
            intArrayOf()
        } else {
            postorder.copyOfRange(indexedValue.index, postorder.size - 1)
        }

        return rightTree.all { it > postorder.last() } && verifyTreeOrder(leftTree) && verifyTreeOrder(rightTree)

    }
}