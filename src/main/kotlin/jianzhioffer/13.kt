package jianzhioffer

/**
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/description/
 *
 * 家居整理师将待整理衣橱划分为 m x n 的二维矩阵 grid，其中 grid[i][j] 代表一个需要整理的格子。整理师自 grid[0][0] 开始 逐行逐列 地整理每个格子。
 *
 * 整理规则为：在整理过程中，可以选择 向右移动一格 或 向下移动一格，但不能移动到衣柜之外。同时，不需要整理 digit(i) + digit(j) > cnt 的格子，其中 digit(x) 表示数字 x 的各数位之和。
 *
 * 请返回整理师 总共需要整理多少个格子。
 */
class Solution_13{
    fun wardrobeFinishing(m: Int, n: Int, cnt: Int): Int {
        val visited = Array(m) { BooleanArray(n) }
        return dfs(0, 0, m, n, cnt, visited)
    }

    fun dfs(i: Int, j: Int, m: Int, n: Int, cnt: Int, visited: Array<BooleanArray>): Int {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || digitSum(i) + digitSum(j) > cnt) {
            return 0
        }
        visited[i][j] = true
        return 1 + dfs(i + 1, j, m, n, cnt, visited) + dfs(i, j + 1, m, n, cnt, visited)
    }

    fun digitSum(num: Int): Int {
        var sum = 0
        var temp = num
        while (temp > 0) {
            sum += temp % 10
            temp /= 10
        }
        return sum
    }
}