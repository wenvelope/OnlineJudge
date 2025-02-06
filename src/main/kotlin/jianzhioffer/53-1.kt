package jianzhioffer


/**
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/description/
 *
 * 统计目标成绩的出现次数
 *
 * 二分 注意边界
 */
class Solution_53_1 {
    fun countTarget(scores: IntArray, target: Int): Int {
        return searchTarget(scores, target, 0, scores.size - 1)
    }

    fun searchTarget(scores: IntArray, target: Int, startIndex: Int, endIndex: Int): Int {
        var leftIndex = startIndex
        var rightIndex = endIndex
        while (leftIndex <= rightIndex && leftIndex >= 0 && rightIndex < scores.size) {
            var midIndex = (leftIndex + rightIndex) shr 1
            if (scores[midIndex] > target) {
                rightIndex = midIndex - 1
            } else if (scores[midIndex] < target) {
                leftIndex = midIndex + 1
            } else {
                return countTargets(scores, target, midIndex)
            }
        }
        return 0
    }

    private fun countTargets(scores: IntArray, target: Int, midIndex: Int): Int {
        var leftIndex = midIndex - 1
        var rightIndex = midIndex + 1
        var count = 0
        while (leftIndex >= 0) {
            if (scores[leftIndex] == target) {
                count++
                leftIndex--
            } else {
                break
            }
        }

        while (rightIndex < scores.size) {
            if (scores[rightIndex] == target) {
                count++
                rightIndex++
            } else {
                break
            }
        }
        return count + 1

    }
}