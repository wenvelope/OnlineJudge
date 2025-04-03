package jianzhioffer2

/**
 * 某班级 n 位同学的学号为 0 ~ n-1。点名结果记录于升序数组 records。假定仅有一位同学缺席，请返回他的学号。
 *
 *
 * 输入：records = [0,1,2,3,5]
 * 输出：4
 */

class Solution_53_2 {
    fun takeAttendance(records: IntArray): Int {
        //二分查找对应区间
        var left = 0
        var right = records.lastIndex
        while (left < right && left <= records.lastIndex && left >= 0) {
            val mid = (left + right) / 2
            if (records[mid] != mid) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return if (left == records[left]){
            left+1
        }else{
            left
        }
    }
}