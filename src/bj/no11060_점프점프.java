package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: 2019-04-30
public class no11060_점프점프 {

    static int MAX = 987654321;
    static int N;
    static int[] miro = new int[1001];
    static int[] dp = new int[1001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            miro[i] = Integer.parseInt(st.nextToken());
        }

//        Arrays.fill(dp, MAX);
        for (int i = 1; i <= N; i++) {
            dp[i] = MAX;
        }

        int result = dp(1, 0);
        if (result == MAX)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    static int dp(int index, int jumpCount) {
        if (index >= N) return 0;
        if (dp[index] != MAX) return dp[index];

        for (int i = 1; i <= miro[index]; i++) {
            int temp = dp(index + i, jumpCount + 1);

            if (temp == MAX) continue;

            dp[index] = Math.min(dp[index], temp + 1);
        }

        return dp[index];
    }
}
