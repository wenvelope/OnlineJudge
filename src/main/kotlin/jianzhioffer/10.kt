package jianzhioffer

class Solution_10{
    fun fib(n: Int): Int {
        if (n == 0){
            return 0
        }
        if (n == 1){
            return 1
        }
        val dp = IntArray(n + 1)
        dp[0] = 0
        dp[1] = 1
        for (i in 2..n) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007
        }
        return dp[n]
    }
}