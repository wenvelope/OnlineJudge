package jianzhioffer2

import java.util.PriorityQueue

/**
 * 仓库管理员以数组 stock 形式记录商品库存表，其中 stock[i] 表示对应商品库存余量。请返回库存余量最少的 cnt 个商品余量，返回 顺序不限。
 */

class Solution_40 {
    fun inventoryManagement(stock: IntArray, cnt: Int): IntArray {
        if (cnt==0) return intArrayOf()
        return quickSort(stock, cnt, 0, stock.lastIndex)
    }

    fun quickSort(stock: IntArray, cnt: Int, left: Int, right: Int): IntArray {
        var l = left;
        var r = right;
        val mid = l;
        while (l < r) {
            while (l < r && stock[r] >= stock[mid]) {
                r--
            }
            while (l < r && stock[l] <= stock[mid]) {
                l++
            }
            stock.swap(l, r)
        }
        stock.swap(left,l)
        if (l < cnt-1) {
           return quickSort(stock, cnt, l + 1, right)
        }
        if (l > cnt-1) {
            return   quickSort(stock, cnt, left, l - 1)
        }
        return stock.copyOf(cnt)
    }

    private fun IntArray.swap(left: Int, right: Int) {
        val temp = this[left]
        this[left] = this[right]
        this[right] = temp
    }
}

fun main() {
    val solution = Solution_40()
    val stock = intArrayOf(0,0,2,3,2,1,1,2,0,4)
    val cnt = 10

}