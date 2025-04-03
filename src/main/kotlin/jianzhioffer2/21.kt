package jianzhioffer2


/**
 * 教练使用整数数组 actions 记录一系列核心肌群训练项目编号。为增强训练趣味性，需要将所有奇数编号训练项目调整至偶数编号训练项目之前。请将调整后的训练项目编号以 数组 形式返回。
 *
 *
 * 输入：actions = [1,2,3,4,5]
 * 输出：[1,3,5,2,4]
 * 解释：为正确答案之一
 *
 *
 */
class Solution_21 {
    fun trainingPlan(actions: IntArray): IntArray {
        var i = 0
        var j = 1
        while (i <= j && j < actions.size) {
            if (actions[j] % 2 == 0) {
                j++
            } else {
                actions.swap(i, j)
                i++
                j++
            }
        }
        return actions
    }

    private fun IntArray.swap(indexA: Int, indexB: Int) {
        val temp = this[indexA]
        this[indexA] = this[indexB]
        this[indexB] = temp
    }
}