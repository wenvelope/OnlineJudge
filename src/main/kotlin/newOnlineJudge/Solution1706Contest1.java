package newOnlineJudge;

import java.util.Arrays;

public class Solution1706Contest1 {
    public int sex = 1;
    public static String zixian = "houzi";

    public static void main(String[] args) {
        char[][] matrix = new char[3][2];
        matrix[0][0] = '1';
        matrix[0][1] = '2';
        matrix[1][0] = '3';
        matrix[1][1] = '4';
        matrix[2][0] = '5';
        matrix[2][1] = '6';

        char[][] y = rotate(matrix);
        Arrays.stream(y).toList().forEach(System.out::println);

    }

    /**
     * 1 2
     * 3 4
     * 5 6
     *
     * @param matrix
     * @return
     */

    public static char[][] rotate(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        char[][] nt = new char[n][m];
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<n;j++){
                nt[j][m-i-1]=matrix[i][j];
            }
        }
        return nt;
    }

}