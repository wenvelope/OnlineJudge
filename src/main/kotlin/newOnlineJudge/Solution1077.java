package newOnlineJudge;

import java.util.Scanner;

/**
 * 题目描述
 * 对于一个5位数而言：abcde，可以构成3个3位数abc、bcd、cde。
 * 如果这个5位数是n的倍数，并且3个3位数也是n的倍数，那么这个5位数就是n的超级倍数。
 * 输入格式
 * 输入存在多组测试数据，对于每组测试数据输入一个n(10<=n<=999)。
 * 输出格式
 * 每组测试数据，如果存在超级倍数，从小到大依次输出超级倍数，否则输出No。
 * 每组测试数据之间以一个空行分隔。
 */
public class Solution1077 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int nt = 10000;
            int n = s.nextInt();
            boolean flag = false;
            while (nt <= 99999) {
                int a, b, c, d, e, abc, bcd, cde;
                a = nt / 10000;
                b = nt / 1000 % 10;
                c = nt / 100 % 10;
                d = nt / 10 % 10;
                e = nt % 10;
                abc = 100 * a + 10 * b + c;
                bcd = 100 * b + 10 * c + d;
                cde = 100 * c + 10 * d + e;
                if (abc % n == 0 && bcd % n == 0 && cde % n == 0 && nt % n == 0) {
                    System.out.println(nt);
                    flag = true;
                }
                nt++;
            }
            if (!flag) {
                System.out.println("No");
            }
            if (s.hasNextInt()) {
                System.out.println();
            }
        }
    }
}
