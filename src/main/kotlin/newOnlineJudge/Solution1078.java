package newOnlineJudge;

import java.util.Scanner;

/**
 * 题目描述
 * 在一个n*n的网格图上有m个探测器，第i个探测器位于(xi,yi)位置，探测半径为ri。
 * 求出n*n个点中有多少个是安全的点，即未被探测的点。
 * 输入格式
 * 第一行为两个整数n,m(1<=n<=100,1<=m<=n*n)
 * 接下来m行每行3个整数表示xi,yi,ri（1<=xi,yi,ri<=n）
 * 输出格式
 * 输出一个整数表示答案
 * 输入样例
 * 5 2
 * 3 3 1
 * 4 2 1
 * 输出样例
 * 17
 */
public class Solution1078 {
    public static void main(String[] args) {
        Scanner sb = new Scanner(System.in);
        int n = sb.nextInt();
        int m = sb.nextInt();
        int safe = 0;
        for (int t=0;t<m;t++){
            int xi, yi, ri;
            xi = sb.nextInt();
            yi = sb.nextInt();
            ri = sb.nextInt();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int distinguish = (xi - i)*(xi-i) + (yi - j)*(yi-j) - ri*ri;
                    if (distinguish > 0) {
                        ++safe;
                    }
                }
            }
        }
        System.out.println(safe);
    }
}

