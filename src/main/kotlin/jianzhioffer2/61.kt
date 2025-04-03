package jianzhioffer2

/**
 * 展览馆展出来自 13 个朝代的文物，每排展柜展出 5 个文物。某排文物的摆放情况记录于数组 places，
 * 其中 places[i] 表示处于第 i 位文物的所属朝代编号。其中，编号为 0 的朝代表示未知朝代。请判断并返回这排文物的所属朝代编号是否能够视为连续的五个朝代（如遇未知朝代可算作连续情况）。
 *
 * 输入：places = [0, 6, 9, 0, 7]
 * 输出：True
 */

class Solution_61 {
    fun checkDynasty(places: IntArray): Boolean {
        //0当成大小王

        if (places.filter { it!=0 }.toSet().size != places.filter { it!=0 }.size){
            return false
        }
        //先排序
        val max = places.filter { it!=0 }.maxOrNull()

        val min = places.filter { it!=0 }.minOrNull()

        val numOfZero = places.count {
            it == 0
        }

        if (max == null) {
            return true
        }

        if (min == null) {
            return true
        }

        return (max - min + 1) - (places.size - numOfZero) <= numOfZero

    }
}

fun main() {
    val so = Solution_61()
    val list = intArrayOf(0, 6, 9, 0, 7)
    so.checkDynasty(list)
}