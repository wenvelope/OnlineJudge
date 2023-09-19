package newOnlineJudge;

import java.util.Scanner;

/**
 * 一个激动的人一看到2就说“Hello2”，看到n就说“Hellon”。请编程实现。
 */
public class Solution1002 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            System.out.println("Hello"+s.nextInt());
        }
    }
}

