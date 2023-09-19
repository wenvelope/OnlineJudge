package newOnlineJudge;

import java.util.Scanner;

/**
 * 题目描述
 * 给定两个整数a，b(0<=a, b<=1000)，计算a+b的值。
 * 输入格式
 * 有多组测试数据，每组一行，每行有两个整数a，b。
 * 输出格式
 * 输出a+b的值
 */
public class Solution1000 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            int a = s.nextInt();
            int b = s.nextInt();
            System.out.println(a + b);
        }
    }
}