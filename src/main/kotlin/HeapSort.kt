fun main() {
    val mutableList = arrayListOf(38, 27, 43, 3, 9, 82, 10)
    println(mutableList.heapSort().let { mutableList })
}

/**
 * 堆排序
 * 大顶堆 小顶堆
 * 可以拿到一个最值然后 继续恢复堆 如此往复
 *
 * 当前元素索引为i
 * 父元素的索引 (i-1)/2
 * 左孩子 i*2+1
 * 右孩子 i*2+2
 *
 * 最后一个非叶子节点 就是最后一个叶子节点的父节点
 * 最后一个叶子节点的索引为 size-1
 * 父节点为 ((size-1)-1)/2 就是 size/2-1
 */
fun MutableList<Int>.heapSort() {
    // 建堆
    for (index in (size / 2 - 1) downTo 0) {
        heapify(this, index, size)
    }

    // 排序
    for (index in size - 1 downTo 0) {
        swap(index, 0)
        heapify(this, 0, index)
    }

}

fun heapify(mList: MutableList<Int>, index: Int, size: Int) {
    var largest = index
    val leftChild = largest * 2 + 1
    val rightChild = largest * 2 + 2

    if (leftChild <= size - 1 && mList[leftChild] > largest) {
        largest = leftChild
    }

    if (rightChild <= size - 1 && mList[rightChild] > largest) {
        largest = rightChild
    }

    if (largest != index) {
        mList.swap(largest, index)
        heapify(mList, largest, size)
    }

}