import java.util.Stack

fun mergeSort(arr: IntArray) {
    val stack = Stack<Pair<Int, Int>>()
    stack.push(0 to arr.size - 1)

    while (!stack.isEmpty()) {
        val (left, right) = stack.pop()

        if (left < right) {
            val mid = left + (right - left) / 2
            stack.push(left to mid)
            stack.push(mid + 1 to right)
            merge(arr, left, mid, right)
        }
    }
}

fun merge(arr: IntArray, left: Int, mid: Int, right: Int) {
    val leftArr = arr.copyOfRange(left, mid + 1)
    val rightArr = arr.copyOfRange(mid + 1, right + 1)

    var i = 0
    var j = 0
    var k = left

    while (i < leftArr.size && j < rightArr.size) {
        if (leftArr[i] <= rightArr[j]) {
            arr[k++] = leftArr[i++]
        } else {
            arr[k++] = rightArr[j++]
        }
    }

    while (i < leftArr.size) {
        arr[k++] = leftArr[i++]
    }

    while (j < rightArr.size) {
        arr[k++] = rightArr[j++]
    }
}

fun main() {
    val arr = intArrayOf(38, 27, 43, 3, 9, 82, 10)
    println("Unsorted array: ${arr.joinToString()}")
    mergeSort(arr)
    println("Sorted array: ${arr.joinToString()}")
}