import java.util.*


fun main() {
    val mutableList = arrayListOf(3,23,5435,2323,43,32,43)
    println(mutableList)

    println( mutableList.quickSort().let { mutableList })

}

/**
 *快排
 * 思想：分治
 * 1.从大到小每一层都一分为二 分到不能再分为止
 * 2.对于每一个小部分 都选定一个和标志位 使得标志位的左边都小于右边
 */
fun MutableList<Int>.quickSort() {
    if (this.isEmpty()) {
        return
    }

    val stack = Stack<Int>()
    stack.push(0)
    stack.push(this.size - 1)

    while (stack.isNotEmpty()) {
        val highIndex = stack.pop()
        val lowIndex = stack.pop()

        if (lowIndex < highIndex) {
            val flagIndex = partition(mList = this, lowIndex = lowIndex, highIndex = highIndex)

            stack.push(lowIndex)
            stack.push(flagIndex - 1)

            stack.push(flagIndex + 1)
            stack.push(highIndex)
        }

    }
}

/**
 * 选取一个标志位 让列表中的左边小于标志位右边大于标志位
 *
 * @return 标志位的索引
 */
fun partition(mList: MutableList<Int>, lowIndex: Int, highIndex: Int): Int {
    val flag = mList[highIndex]
    //最后一个小于flag的元素的位置 初始为lowIndex-1
    var theLowIndex = lowIndex - 1


    for (index in lowIndex until  highIndex){
        if (mList[index]<flag){
            mList.swap(theLowIndex+1,index)
            theLowIndex++
        }
    }

    mList.swap(theLowIndex + 1, highIndex)
    return theLowIndex + 1
}

/**
 * 交换两个索引对应元素的位置
 */
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    set(index = index1, element = this[index2])
    set(index = index2, element = temp)
}
