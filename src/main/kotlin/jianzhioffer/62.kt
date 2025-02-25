package jianzhioffer

class Solution_62 {
    fun iceBreakingGame(num: Int, target: Int): Int {
        var index = 0
        for (i in 2..num) {
            index = (index + target) % i
        }
        return index
    }
}