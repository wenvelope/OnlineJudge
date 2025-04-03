package jianzhioffer2

/**
 * 待传输文件被切分成多个部分，按照原排列顺序，每部分文件编号均为一个 正整数（至少含有两个文件）。传输要求为：连续文件编号总和为接收方指定数字 target 的所有文件。请返回所有符合该要求的文件传输组合列表。
 *
 * 注意，返回时需遵循以下规则：
 *
 * 每种组合按照文件编号 升序 排列；
 * 不同组合按照第一个文件编号 升序 排列。
 *
 *
 * 输入：target = 12
 * 输出：[[3, 4, 5]]
 * 解释：在上述示例中，存在一个连续正整数序列的和为 12，为 [3, 4, 5]。
 */

class Solution_57_2 {
    fun fileCombination(target: Int): Array<IntArray> {
        val result = arrayListOf<IntArray>()
        // 正整数
        val fileList = IntArray(
            size = target/2,
            init = { index ->
                index + 1
            }
        )
        if (target == 1) {
            return result.toTypedArray()
        }

        var leftPoint = 0
        var rightPoint = 1
        var sum = fileList[leftPoint] + fileList[rightPoint]
        while (leftPoint < rightPoint ) {
            if (sum < target) {
                rightPoint++
                if (rightPoint < fileList.size) {
                    sum += fileList[rightPoint]
                } else {
                    break
                }
            } else if (sum > target) {
                sum -= fileList[leftPoint]
                leftPoint++
            } else {
                val oneResult = fileList.copyOfRange(leftPoint, rightPoint + 1)
                result.add(oneResult)

                //删除第一个元素继续向后推进
                sum -= fileList[leftPoint]
                leftPoint++
            }
        }
        return result.toTypedArray()
    }
}

fun main() {
    val so = Solution_57_2()
    println( so.fileCombination(12))
}