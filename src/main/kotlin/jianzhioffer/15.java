package jianzhioffer;

/**
 * https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/description/
 */
class Solution_15 {
    public int hammingWeight(int n) {
        int rec = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i))!=0){
                rec++;
            }
        }
        return rec;
    }
}
