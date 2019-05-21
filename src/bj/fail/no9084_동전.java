package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no9084_동전 {

    static int T, N, M;
    static int[] coin = new int[20];
    static int[] dp = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                coin[j] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());

            Arrays.fill(dp, 0);
            dp[0] = 1;

            for (int j = 0; j < N; j++) {
                for (int k = coin[j]; k <= M; k++) {
                    dp[k] += dp[k - coin[j]];
                }
            }

            System.out.println(dp[M]);
        }
    }
}
