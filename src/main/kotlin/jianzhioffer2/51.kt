package jianzhioffer2


/**
 *在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。
 *
 */
class Solution_51 {
    var result = 0

    fun reversePairs(record: IntArray): Int {
        val arrayList = ArrayList<Int>()
        mergeSort(record, 0, record.lastIndex, arrayList)
        return result
    }

    fun mergeSort(record: IntArray, left: Int, right: Int, tempList: MutableList<Int>) {
        if (left >= right) {
            return
        }
        val mid = (left + right) / 2
        mergeSort(record, left, mid, tempList)
        mergeSort(record, mid + 1, right, tempList)
        //合并
        merge(record, left, mid, right, tempList)

    }

    private fun merge(record: IntArray, left: Int, mid: Int, right: Int, tempList: MutableList<Int>) {
        tempList.clear()
        var leftStart = left
        var rightStart = mid + 1
        while (leftStart <= mid && rightStart <= right) {
            if (record[leftStart] > record[rightStart]) {
                tempList.add(record[rightStart])
                rightStart++
                result += (mid - leftStart) + 1
            } else {
                tempList.add(record[leftStart])
                leftStart++
            }
        }
        while (leftStart <= mid) {
            tempList.add(record[leftStart])
            leftStart++
        }

        while (rightStart <= right) {
            tempList.add(record[rightStart])
            rightStart++
        }

        tempList.forEachIndexed { index, value ->
            record[index + left] = value
        }
    }
}