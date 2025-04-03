package jianzhioffer2


/**
 * 为了深入了解这些生物群体的生态特征，你们进行了大量的实地观察和数据采集。
 * 数组 arrayA 记录了各个生物群体数量数据，其中 arrayA[i] 表示第 i 个生物群体的数量。
 * 请返回一个数组 arrayB，该数组为基于数组 arrayA 中的数据计算得出的结果，其中 arrayB[i] 表示将第 i 个生物群体的数量从总体中排除后的其他数量的乘积。
 *
 *
 * 不能用除法
 *
 */
class Solution_66 {
    fun statisticalResult(arrayA: IntArray): IntArray {
        //前缀积
        val result = IntArray(arrayA.size)

        var current = 1
        for (i in arrayA.indices) {
            result[i] = current
            current *= arrayA[i]
        }

        current = 1
        for (i in arrayA.size - 1 downTo 0) {
            result[i] *= current
            current *= arrayA[i]
        }

        return result
    }
}