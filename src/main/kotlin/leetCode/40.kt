package leetCode
fun main() {
    val candidates = intArrayOf(
        10, 1, 2, 7, 6, 1, 5
    )
    val result = combinationSum2(candidates, 8)
    println(result.toString())
}

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val resultList = arrayListOf<ArrayList<Int>>()
    val tempList = arrayListOf<Int>()
    val hashMap = HashMap<Int, Int>().apply {
        candidates.forEach {
            put(it, if (get(it) == null) 1 else get(it)!! + 1)
        }
    }
    combineChange(tempList, resultList, 0, candidates.distinct().sorted(), target, hashMap)
    return resultList
}

fun combineChange(
    tempList: ArrayList<Int>,
    resultList: ArrayList<ArrayList<Int>>,
    index: Int,
    candidates: List<Int>,
    target: Int,
    dataMap: HashMap<Int, Int>
) {
    val sum = tempList.sum()
    if (sum >= target) {
        if (sum == target) {
            val list = ArrayList(tempList)
            resultList.add(list)
            return
        }
        return
    }
    for (item in candidates) {
        if (dataMap[item] == 0) {
            continue
        }
        if (tempList.size >= 1 && item < tempList[tempList.size - 1]) {
            continue
        }
        tempList.add(item)
        dataMap[item] = dataMap[item]!! - 1
        combineChange(tempList, resultList, index + 1, candidates, target, dataMap)
        tempList.removeAt(index)
        dataMap[item] = dataMap[item]!! + 1
    }
}

