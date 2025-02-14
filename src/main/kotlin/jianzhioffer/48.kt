package jianzhioffer

import kotlin.math.max

/**
 *
 * https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/description/
 *
 *
 */
class Solution_48 {
    fun dismantlingAction(arr: String): Int {
        if (arr.isEmpty()) {
            return 0
        }
        val hashSet = HashSet<Char>()
        var leftPointer = 0
        var rightPointer = 0
        var maxLength = 0
        while (rightPointer < arr.length) {
            val insertSuccess = hashSet.add(arr[rightPointer])
            if (insertSuccess) {
                rightPointer++
                maxLength = max(maxLength, hashSet.size)
            } else {
                hashSet.remove(arr[leftPointer])
                leftPointer++
            }
        }
        return maxLength
    }

}