package jianzhioffer2

/**
 * 仓库管理员以数组 stock 形式记录商品库存表。stock[i] 表示商品 id，可能存在重复。请返回库存表中数量大于 stock.length / 2 的商品 id。
 *
 *
 * 输入：stock = [6, 1, 3, 1, 1, 1]
 * 输出：1
 */

class Solution_2 {
    fun inventoryManagement(stock: IntArray): Int {
        var result = 0
        var votes = 0
        stock.forEach {
            if (votes == 0) result = it
            if (it == result) {
                votes++
            } else {
                votes--
            }
        }
        return result
    }
}