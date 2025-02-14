package jianzhioffer


/**
 *
 *
 * https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 *
 *
 * 某套连招动作记作仅由小写字母组成的序列 arr，其中 arr[i] 第 i 个招式的名字。请返回第一个只出现一次的招式名称，如不存在请返回空格。
 *
 */
class Solution_50 {
    fun dismantlingAction(arr: String): Char {
        val queueList = mutableListOf<Char>()
        val garbageList = hashSetOf<Char>()
        arr.forEach {
            val isContain = queueList.contains(it)
            if (!isContain) {
                queueList.add(it)
            } else {
                garbageList.add(it)
            }
        }
        val char = queueList.find { !garbageList.contains(it) }
        return char ?: ' '
    }
}