package jianzhioffer2

/**
 * 某班级考试成绩按非严格递增顺序记录于整数数组 scores，请返回目标成绩 target 的出现次数。
 *
 *
 * 输入: scores = [2, 2, 3, 4, 4, 4, 5, 6, 6, 8], target = 4
 * 输出: 3
 *
 *
 */

class Solution_53_1 {
    fun countTarget(scores: IntArray, target: Int): Int {
        //二分寻找目标
        var sum = 0
        val index = findTarget(scores, target, 0, scores.lastIndex)
        //两侧寻找相同值
        if (index == -1) {
            return 0
        } else {
            sum += 1
            var leftPoint = index - 1
            var rightPoint = index + 1
            while (leftPoint >= 0) {
                if (scores[leftPoint] == target) {
                    sum += 1
                    leftPoint--
                } else {
                    break
                }
            }
            while (rightPoint <= scores.lastIndex) {
                if (scores[rightPoint] == target) {
                    sum += 1
                    rightPoint++
                } else {
                    break
                }
            }
        }
        return sum

    }

    private fun findTarget(scores: IntArray, target: Int, left: Int, right: Int): Int {
        if (left >= right) {
            if (left == right) {
                return if (target == scores[left]) {
                    left
                } else {
                    -1
                }
            }
            return -1
        }

        val mid = (left + right) / 2

        return if (scores[mid] == target) {
            mid
        } else if (scores[mid] > target) {
            findTarget(scores, target, left, mid)
        } else {
            findTarget(scores, target, mid + 1, right)
        }

    }
}

fun main() {
    val so = Solution_53_1()
    val list = intArrayOf(2, 2, 3, 4, 4, 4, 5, 6, 6, 8)
    so.countTarget(list,4)
}