package newOnlineJudge;

import java.util.Scanner;

public class Solution1003 {
    public static void main(String[] args) {
        Scanner sb = new Scanner(System.in);
        while (sb.hasNextInt()) {
            int n = sb.nextInt();
            int sum = n * (n + 1) / 2;
            System.out.println(sum);
        }
    }
}
