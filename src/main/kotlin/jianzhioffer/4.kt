package jianzhioffer

/**
 *
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 *
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 * Given target = 20, return false.
 *
 *[leetCode](https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/description/)
 */


class Solution_4 {
    fun findTargetIn2DPlants(plants: Array<IntArray>, target: Int): Boolean {
        if (plants.isEmpty() || plants[0].isEmpty()) {
            return false
        }
        var x_index = plants[0].size - 1
        var y_index = 0

        while (plants[y_index][x_index] != target) {
            if (plants[y_index][x_index] < target) {
                y_index += 1
            } else if (plants[y_index][x_index] > target) {
                x_index -= 1
            }

            //验证边界
            if (y_index >= plants.size || x_index < 0) {
                return false
            }
        }
        return true
    }
}