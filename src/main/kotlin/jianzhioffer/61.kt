package jianzhioffer


/**
 *
 * 剑指offer61.扑克牌的顺子
 *
 * https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/description/
 *
 * 有重复就算错
 *
 */
class Solution_61 {
    fun checkDynasty(places: IntArray): Boolean {
        var minNum = Int.MAX_VALUE
        var maxNum = Int.MIN_VALUE
        var numOfZero = 0
        val array = IntArray(13)
        for (i in 0 until places.size) {
            if (places[i] == 0) {
                numOfZero++
                continue
            } else {
                array[places[i]] = 1
            }

            if (places[i] > maxNum) {
                maxNum = places[i]
            }

            if (places[i] < minNum) {
                minNum = places[i]
            }
        }

        val needNum = maxNum - minNum + 1
        val realNum = array.sum()
        if (realNum != places.size - numOfZero) {
            return false
        }
        return realNum == needNum || realNum + numOfZero >= needNum
    }
}

fun main() {
    println(Solution_61().checkDynasty(intArrayOf(9,2,6,7,10)))
}