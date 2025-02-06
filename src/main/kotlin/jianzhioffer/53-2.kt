package jianzhioffer


/**
 * 某班级 n 位同学的学号为 0 ~ n-1。点名结果记录于升序数组 records。假定仅有一位同学缺席，请返回他的学号。
 *
 *  https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/description/
 */
class Solution_53_2 {
    fun takeAttendance(records: IntArray): Int {
        return binarySearch(records)
    }

    fun binarySearch(records: IntArray): Int {
        var leftIndex = 0
        var rightIndex = records.size - 1
        while (leftIndex <= rightIndex) {
            var midIndex = (leftIndex + rightIndex) / 2
            if (records[midIndex] == midIndex) {
                leftIndex = midIndex + 1
            } else {
                rightIndex = midIndex - 1
                if (leftIndex > rightIndex) {
                    return midIndex
                }
            }
        }
        return records.size
    }
}

fun main() {
    val s = Solution_53_2()
    println(s.takeAttendance(intArrayOf(0, 1, 2, 3, 5)))
}