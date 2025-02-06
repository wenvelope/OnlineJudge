import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.index
import java.util.Stack

fun main() {
    val mutableList = arrayListOf(38, 27, 43, 3, 9, 82, 10)
    println(mutableList.mergeSort().let { mutableList })
}

/**
 * 归并排序
 * 分治
 * 核心思想:
 * 1.从小到大 先把列表分成所有的小块 每一块只有一个元素
 * 2.这样 所有块都可以视为有序 两两合并 合并之后的块也是有序的
 * 3.关键在于合并的方法 选用了临时数组来存储 排序完毕之后再整体替换。
 */

fun MutableList<Int>.mergeSort(): Int {
    val low = 0
    val high = size - 1
    val tempList = arrayListOf<Int>()

    var count = 0

    val stack = Stack<Int>()
    val taskStack = Stack<Int>()

    stack.push(low)
    stack.push(high)

    while (stack.isNotEmpty()) {
        val highIndex = stack.pop()
        val lowIndex = stack.pop()

        val mid = (lowIndex + highIndex) / 2

        taskStack.push(lowIndex)
        taskStack.push(highIndex)

        if (lowIndex < highIndex) {
            stack.push(lowIndex)
            stack.push(mid)

            stack.push(mid + 1)
            stack.push(highIndex)
        }
    }

    while (taskStack.isNotEmpty()) {
        val highIndex = taskStack.pop()
        val lowIndex = taskStack.pop()

        if (lowIndex < highIndex) {
            tempList.clear()
            var leftIndex = lowIndex
            val leftMax = (lowIndex + highIndex) / 2
            val rightMax = highIndex
            var rightIndex = (lowIndex + highIndex) / 2 + 1

            while (leftIndex <= leftMax && rightIndex <= rightMax) {
                if (this[leftIndex] < this[rightIndex]) {
                    tempList.add(this[leftIndex])
                    leftIndex++
                } else {
                    tempList.add(this[rightIndex])
                    rightIndex++
                    count += (leftMax + 1 - leftIndex)
                }
            }

            while (leftIndex <= leftMax) {
                tempList.add(this[leftIndex])
                leftIndex++
            }

            while (rightIndex <= rightMax) {
                tempList.add(this[rightIndex])
                rightIndex++
            }

            tempList.forEachIndexed{
                index,value ->
                this[lowIndex+index] = value
            }

        }
    }

    return count

}