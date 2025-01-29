package jianzhioffer


/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *  [牛客](https://www.nowcoder.com/practice/6fe361ede7e54db1b84adc81d09d8524?tpId=13&tqId=11203&tab=answerKey&from=cyc_github)
 **/
object Solution3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    fun duplicate(numbers: IntArray): Int {
        // write code here
        numbers.forEachIndexed { index, number ->
            //判断当前位置数字是否再自己的位置上
            while (numbers[index] != index) {
                if (numbers[index] == numbers[numbers[index]]) {
                    return numbers[index]
                } else {
                    swap(numbers, index, numbers[index])
                }
            }
        }
        return -1
    }

    fun swap(numbers: IntArray, x: Int, y: Int) {
        require(
            x < numbers.size && y < numbers.size
        )
        val temp = numbers[x]
        numbers[x] = numbers[y]
        numbers[y] = temp
    }
}


object Solution3_2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    val hashSet = HashSet<Int>()

    fun duplicate(numbers: IntArray): Int {
        // write code here
        numbers.forEach {
            if (!hashSet.add(it)) {
                return it
            }
        }
        return -1
    }

}