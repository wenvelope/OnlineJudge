package newOnlineJudge;

import java.util.HashSet;
import java.util.Set;

public class Solution1740 {
    public static void main(String[] args) {
        int N = 123456;
        int category1 = 0;
        int category2 = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 2; i < N; i++) {
            if (isPrime(i)) {
                set.add(i);
            }
        }
        for (int item : set) {
            int p2 = N - item;
            if (isPrime(p2)) {
                category1++;
            }
        }

        for (int item : set) {
            int pt = N - item;
            category2 += isValidate(pt, set);
        }

        System.out.println(category1 + " " + category2);
    }

    private static int isValidate(int pt, Set<Integer> set) {
        int category2 = 0;
        for (int p2 : set) {
            if (pt%p2==0){
                int p3 = pt / p2;
                if (set.contains(p3)) {
                    category2++;
                }
            }
        }
        return category2;
    }

    public static boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
