package jianzhioffer

/**
 *最小的k个数
 *
 * 仓库管理员以数组 stock 形式记录商品库存表，其中 stock[i] 表示对应商品库存余量。请返回库存余量最少的 cnt 个商品余量，返回 顺序不限。
 *输入：stock = [2,5,7,4], cnt = 1
 * 输出：[2]
 *
 * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/description/
 *
 *
 * 思路：快排
 * pivot
 */
class Solution_40 {
    fun inventoryManagement(stock: IntArray, cnt: Int): IntArray {
        bottomCnt(stock, cnt, startIndex = 0, endIndex = stock.size - 1)
        val result = IntArray(cnt) { i ->
            stock[i]
        }
        return result
    }

    fun bottomCnt(stock: IntArray, cnt: Int, startIndex: Int, endIndex: Int) {
        if (cnt == 0) {
            return
        }
        if (startIndex > endIndex) {
            return
        }
        val pivotIndex = partSort(stock, startIndex, endIndex)
        if (pivotIndex == cnt - 1 || pivotIndex == cnt) {
            return
        } else if (pivotIndex > cnt - 1) {
            bottomCnt(stock, cnt, startIndex, pivotIndex - 1)
        } else {
            bottomCnt(stock, cnt, pivotIndex + 1, endIndex)
        }

    }


    fun partSort(stock: IntArray, start: Int, end: Int): Int {
        val pivot = stock[end]
        var lowIndex = start
        for (i in start until end) {
            if (stock[i] < pivot) {
                stock.swap(i, lowIndex)
                lowIndex++
            }
        }
        stock.swap(lowIndex, end)
        return lowIndex
    }

    fun IntArray.swap(x: Int, y: Int) {
        require(x in 0..this.size && y in 0..this.size)
        if (x == y) {
            return
        }
        val temp = this[x]
        this[x] = this[y]
        this[y] = temp
    }
}

fun main() {
    val s = Solution_40()
    println(s.inventoryManagement(intArrayOf(2, 5, 7, 4), 1)[0])
    println(intArrayOf(2, 3, 4, 5))
}