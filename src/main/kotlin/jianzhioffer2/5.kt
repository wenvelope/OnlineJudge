package jianzhioffer2

/**
 *假定一段路径记作字符串 path，其中以 "." 作为分隔符。现需将路径加密，加密方法为将 path 中的分隔符替换为空格 " "，请返回加密后的字符串。
 *
 * 输入：path = "a.aef.qerf.bb"
 *
 * 输出："a aef qerf bb"
 */

class Solution_5 {
    fun pathEncryption(path: String): String {
        return  path.replace("."," ")
    }
}