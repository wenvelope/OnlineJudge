package jianzhioffer

import com.jogamp.opengl.math.VectorUtil.mid
import mergeSort
import java.util.Stack

class Solution_51 {

    fun reversePairs(record: IntArray): Int {
        return record.toMutableList().mergeSort()
    }

    private fun mergeSortAndCount(record: IntArray, left: Int, right: Int): Int {
        var count = 0
        if (left < right) {
            val mid = (left + right) / 2
            count += mergeSortAndCount(record, left, mid)
            count += mergeSortAndCount(record, mid + 1, right)
            count += mergeAndCount(record, left, mid, right)
        }
        return count
    }

    private fun mergeAndCount(record: IntArray, left: Int, mid: Int, right: Int): Int {
        val leftArray = record.copyOfRange(left, mid + 1)
        val rightArray = record.copyOfRange(mid + 1, right + 1)

        var i = 0
        var j = 0
        var k = left
        var count = 0

        while (i < leftArray.size && j < rightArray.size) {
            if (leftArray[i] <= rightArray[j]) {
                record[k++] = leftArray[i++]
            } else {
                record[k++] = rightArray[j++]
                count += (mid + 1) - (left + i)
            }
        }

        while (i < leftArray.size) {
            record[k++] = leftArray[i++]
        }

        while (j < rightArray.size) {
            record[k++] = rightArray[j++]
        }

        return count
    }

}