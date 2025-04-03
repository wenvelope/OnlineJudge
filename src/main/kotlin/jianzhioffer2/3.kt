package jianzhioffer2

/**
 * 设备中存有 n 个文件，文件 id 记于数组 documents。若文件 id 相同，则定义为该文件存在副本。请返回任一存在副本的文件 id。
 *
 *
 * 输入：documents = [2, 5, 3, 0, 5, 0]
 * 输出：0 或 5
 */
class Solution {
    fun findRepeatDocument(documents: IntArray): Int {
        val documentHashSet = HashSet<Int>()
        documents.forEach {
            if (!documentHashSet.add(it)) {

                return it
            }
        }
        return -1
    }
}