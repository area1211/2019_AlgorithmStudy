package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: 2019-04-24
//
public class no5557_1학년 {

    static int[] num = new int[101];
    static long[][] dp = new long[101][21];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i <= 100; i++) {
            Arrays.fill(dp[i], -1);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dp(N - 1, num[N]));

    }

    static long dp(int index, int total) {
        if (dp[index][total] != -1) return dp[index][total];
        if (index == 1) {
            if (total == num[index]) return 1;
            else return 0;
        }


        long result = 0;
        int plusSum = total - num[index];
        if (plusSum >= 0 && plusSum <= 20) {
            dp[index - 1][plusSum] = dp(index - 1, plusSum);
            result += dp[index - 1][plusSum];
        }

        int minusSum = total + num[index];
        if (minusSum >= 0 && minusSum <= 20) {
            dp[index - 1][minusSum] = dp(index - 1, minusSum);
            result += dp[index - 1][minusSum];
        }

        dp[index][total] = result;
        return dp[index][total];
    }
}
