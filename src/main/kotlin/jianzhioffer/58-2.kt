package jianzhioffer

/**
 *
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/description/
 *
 * 某公司门禁密码使用动态口令技术。初始密码为字符串 password，密码更新均遵循以下步骤：
 *
 * 设定一个正整数目标值 target
 * 将 password 前 target 个字符按原顺序移动至字符串末尾
 * 请返回更新后的密码字符串。
 */
class Solution_58_2 {
    fun dynamicPassword(password: String, target: Int): String {
        val rightPattern = password.substring(startIndex = target)
        val leftPatter = password.substring(0, target)
        return rightPattern + leftPatter
    }
}