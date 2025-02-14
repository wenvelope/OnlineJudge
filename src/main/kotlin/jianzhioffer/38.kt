package jianzhioffer

import java.util.Arrays

/**
 * 剑指offer38.字符串的排列。解法：DFS+剪枝。具体解法
 *
 *
 * https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/description/
 *
 *
 * 某店铺将用于组成套餐的商品记作字符串 goods，其中 goods[i] 表示对应商品。请返回该套餐内所含商品的 全部排列方式 。
 *
 * 返回结果 无顺序要求，但不能含有重复的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：goods = "agew"
 * 输出：["aegw","aewg","agew","agwe","aweg","awge","eagw","eawg","egaw","egwa","ewag","ewga","gaew","gawe","geaw","gewa","gwae","gwea","waeg","wage","weag","wega","wgae","wgea"]
 */

class Solution_38 {
    val resultArray = mutableListOf<String>()

    fun goodsOrder(goods: String): Array<String> {
        val resultQueue = CharArray(goods.length)
        val goodsSorted = goods.toCharArray()
        Arrays.sort(goodsSorted)
        dfs(goodsSorted, goods.length, 0, resultQueue, BooleanArray(goods.length))
        return resultArray.toTypedArray()
    }

    fun dfs(goods: CharArray, target: Int, hasNum: Int, resultQueue: CharArray, usedIndexArray: BooleanArray) {
        if (hasNum == target) {
            val result = String(resultQueue)
            resultArray.add(result)
            return
        }
        for (i in goods.indices) {
            if (usedIndexArray[i]) continue // 跳过已经使用的字符
            if (i > 0 && goods[i] == goods[i - 1] && !usedIndexArray[i - 1]) continue // 避免重复字符

            resultQueue[hasNum] = goods[i]
            usedIndexArray[i] = true
            dfs(goods, target, hasNum + 1, resultQueue, usedIndexArray)
            usedIndexArray[i] = false
        }
    }

}