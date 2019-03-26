package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2294_동전2 {

    static int n, k;
    static int[] coin = new int[100];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];

        for (int i = 1; i <= k; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (i - coin[j] >= 0
                        && dp[i-coin[j]] != Integer.MAX_VALUE
                        && dp[i] > dp[i - coin[j]] + 1) {
                    dp[i] = dp[i - coin[j]] + 1;
                }
            }

        }

        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
    }
}
