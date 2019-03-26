package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class no1699_제곱수의합 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = (int)Math.sqrt(i); j >= 1; j--) {
                int temp = dp[i - j*j] + 1;
                if (dp[i] > temp || dp[i] == 0) {
                    dp[i] = temp;
                }
            }
        }

        System.out.println(dp[N]);
    }
}
