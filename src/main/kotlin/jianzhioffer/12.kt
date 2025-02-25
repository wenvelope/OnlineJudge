package jianzhioffer

/**
 * https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/description/
 * 剑指offer12.矩阵中的路径
 *
 * 字母迷宫游戏初始界面记作 m x n 二维字符串数组 grid，请判断玩家是否能在 grid 中找到目标单词 target。
 * 注意：寻找单词时 必须 按照字母顺序，通过水平或垂直方向相邻的单元格内的字母构成，同时，同一个单元格内的字母 不允许被重复使用 。
 */
class Solution_12{
    fun wordPuzzle(grid: Array<CharArray>, target: String): Boolean {
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (dfs(grid, target, i, j, 0)) {
                    return true
                }
            }
        }
        return false
    }
    fun dfs(grid: Array<CharArray>, target: String, row: Int, col: Int, index: Int): Boolean {
        if (row < 0 || row >= grid.size || col < 0 || col >= grid[0].size || grid[row][col] != target[index]) {
            return false
        }
        if (index == target.length - 1) {
            return true
        }
        val temp = grid[row][col]
        grid[row][col] = '/'
        val res = dfs(grid, target, row + 1, col, index + 1) ||
                dfs(grid, target, row - 1, col, index + 1) ||
                dfs(grid, target, row, col + 1, index + 1) ||
                dfs(grid, target, row, col - 1, index + 1)
        grid[row][col] = temp
        return res
    }
}