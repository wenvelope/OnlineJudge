package jianzhioffer

import kotlin.collections.toIntArray

/**
 * product
 */
class Solution_66 {
    fun statisticalResult(arrayA: IntArray): IntArray {
        var count_zero = 0

        if (arrayA.isEmpty()) {
            return arrayA
        }

        val product = arrayA.reduce { acc, i ->
            if (i != 0) {
                acc * i
            } else {
                count_zero++
                acc
            }
        }

        if (count_zero >= 2) {
            return IntArray(arrayA.size)
        }


        val result = if (count_zero == 1) {
            arrayA.map {
                if (it == 0) {
                    product
                } else {
                    0
                }
            }
        } else {
            arrayA.map {
                product / it
            }
        }

        return result.toIntArray()
    }
}