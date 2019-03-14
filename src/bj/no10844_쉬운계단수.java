package bj;

import java.util.Scanner;

public class no10844_쉬운계단수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] ans = new int[101][10];
        for (int i = 1; i < 10; i++) {
            ans[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j - 1 >= 0)
                    ans[i][j] += ans[i-1][j-1];
                if (j + 1 <= 9)
                    ans[i][j] += ans[i-1][j+1];

                ans[i][j] %= 1000000000;
            }
        }

        long total = 0;
        for (int i = 0; i < 10; i++) {
            total += ans[N][i];
        }
        System.out.println(total % 1000000000);
    }
}
