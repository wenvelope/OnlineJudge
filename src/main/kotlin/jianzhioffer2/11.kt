package jianzhioffer2

/**
 * 仓库管理员以数组 stock 形式记录商品库存表。stock[i] 表示商品 id，可能存在重复。原库存表按商品 id 升序排列。
 * 现因突发情况需要进行商品紧急调拨，管理员将这批商品 id 提前依次整理至库存表最后。请你找到并返回库存表中编号的 最小的元素 以便及时记录本次调拨。
 * 输入：stock = [4,5,8,3,4]
 * 输出：3
 *
 *
 */

class Solution_11 {
    fun inventoryManagement(stock: IntArray): Int {
        var lastOne = Int.MAX_VALUE
        var currentOne = Int.MAX_VALUE
        if (stock.size==1){
            return stock[0]
        }
        for (index in (stock.lastIndex downTo  0)) {
            if (index == stock.lastIndex) {
                currentOne = stock[index]
            } else {
                lastOne = currentOne
                currentOne = stock[index]
                if (currentOne > lastOne) {
                    return if (lastOne > stock[0]) {
                        stock[0]
                    } else {
                        lastOne
                    }
                }
            }
        }
        return stock[0]
    }
}