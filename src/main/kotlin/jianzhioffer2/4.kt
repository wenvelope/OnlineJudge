package jianzhioffer2


/**
 * m*n 的二维数组 plants 记录了园林景观的植物排布情况，具有以下特性：
 *
 * 每行中，每棵植物的右侧相邻植物不矮于该植物；
 * 每列中，每棵植物的下侧相邻植物不矮于该植物。
 *
 * 请判断 plants 中是否存在目标高度值 target。
 */
class Solution_4 {
    fun findTargetIn2DPlants(plants: Array<IntArray>, target: Int): Boolean {
        if (plants.isEmpty()) return false
        if (plants.first().isEmpty()) return false
        plants.forEach {
            val lastPlant = it.last()
            if (target <= lastPlant) {
                it.forEach { it2->
                    if (target == it2) return true
                }
            }
        }
        return false
    }
}