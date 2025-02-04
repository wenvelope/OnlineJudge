package jianzhioffer

import com.jogamp.newt.util.MonitorModeUtil.getIndex
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.index
import kotlin.math.ceil

/**
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/description/
 */
class Solution_21 {
    fun trainingPlan(actions: IntArray): IntArray {
        for (i in 0 until actions.size) {
            while (getIndex(actions[i], actions.size) != i) {
                actions.swap(i, getIndex(actions[i], actions.size))
            }
        }
        return actions
    }

    fun getIndex(num: Int, size: Int): Int {
        return if (num % 2 == 0) {
            ceil(size / 2.0).toInt() + num / 2 - 1
        } else {
            num / 2
        }
    }

    fun IntArray.swap(index1: Int, index2: Int) {
        val temp = this[index1]
        this[index1] = this[index2]
        this[index2] = temp
    }
}