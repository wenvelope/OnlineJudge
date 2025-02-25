package jianzhioffer

/**
 * 给定一个二维数组 array，请返回「螺旋遍历」该数组的结果。
 *
 * 螺旋遍历：从左上角开始，按照 向右、向下、向左、向上 的顺序 依次 提取元素，然后再进入内部一层重复相同的步骤，直到提取完所有元素。
 */
class Solution_29{
    fun spiralArray(array: Array<IntArray>): IntArray {
        val visited = Array(array.size) { BooleanArray(array[0].size) }
        val result = mutableListOf<Int>()
        dfs(array, visited, result, 0, 0, 0, 0)
        return result.toIntArray()
    }

    fun dfs(array: Array<IntArray>, visited: Array<BooleanArray>, result: MutableList<Int>, x: Int, y: Int, direction: Int, index: Int) {
        if (x < 0 || x >= array.size || y < 0 || y >= array[0].size || visited[x][y]) {
            return
        }
        result.add(array[x][y])
        visited[x][y] = true
        when (direction%4) {
            0 -> {
                dfs(array, visited, result, x, y + 1, direction, index + 1)
                dfs(array, visited, result, x + 1, y, direction + 1, index + 1)
            }
            1 -> {
                dfs(array, visited, result, x + 1, y, direction, index + 1)
                dfs(array, visited, result, x , y-1, direction + 1, index + 1)
            }
            2 -> {
                dfs(array, visited, result, x, y - 1, direction, index + 1)
                dfs(array, visited, result, x -1, y, direction + 1, index + 1)
            }
            3 -> {
                dfs(array, visited, result, x - 1, y, direction, index + 1)
                dfs(array, visited, result, x , y+1, direction + 1, index + 1)
            }
        }
    }
}

fun main() {
    //[[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]
    val sa = Solution_29()
    val array = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(12, 13, 14, 5), intArrayOf(11, 16, 15, 6), intArrayOf(10, 9, 8, 7))
    val result = sa.spiralArray(array).joinToString()
    println(result)
}