package leetCode

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *         this["2"] = "abc"
 *         this["3"] = "def"
 *         this["4"] = "ghi"
 *         this["5"] = "jkl"
 *         this["6"] = "mno"
 *         this["7"] = "pqrs"
 *         this["8"] = "tuv"
 *         this["9"] = "wxyz"
 */
private fun letterCombinations(digits: String): List<String> {

    if (digits.isEmpty() || digits.isBlank()) {
        return emptyList()
    }
    val resultList = arrayListOf<String>()
    val dataMap = HashMap<String, String>().apply {
        this["2"] = "abc"
        this["3"] = "def"
        this["4"] = "ghi"
        this["5"] = "jkl"
        this["6"] = "mno"
        this["7"] = "pqrs"
        this["8"] = "tuv"
        this["9"] = "wxyz"
    }


    val digitsList = digits.toCharArray().toList()
    val tempList = arrayListOf<Char>()
    combine(tempList, resultList, 0, dataMap, digitsList)
    return resultList
}

private fun combine(
    tempList: ArrayList<Char>,
    resultList: ArrayList<String>,
    index: Int,
    dataMap: HashMap<String, String>,
    digitsList: List<Char>
) {
    if (tempList.size == digitsList.size) {
        resultList.add(tempList.joinToString(separator = "") { it ->
            it.toString()
        })
        return
    }
    for (item in dataMap[digitsList[index].toString()]!!.toCharArray()) {
        tempList.add(item)
        combine(tempList, resultList, index + 1, dataMap, digitsList)
        tempList.removeAt(index)
    }
}