package jianzhioffer

import kotlin.math.max
import kotlin.math.min

class Solution_63 {
    fun bestTiming(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0
        for (price in prices) {
            minPrice = min(minPrice, price)
            maxProfit = max(maxProfit, price - minPrice)
        }
        return maxProfit
    }
}