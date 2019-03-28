package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// TODO: 2019-03-28  
public class no11051_이항계수2 {

    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
//                for (int k = j - 1; k <= i - 1; k++) {
//                    dp[i][j] += dp[k][j - 1];
//                }

                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
            }
        }

        System.out.println(dp[N][M] % 10007);
//        System.out.println(dp(N, M));
    }

    static int dp(int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (j == 0) return 1;
        if (dp[i][j] != 0) return dp[i][j];

        int result = 0;
        for (int k = j - 1; k <= i - 1; k++) {
            result += dp(k, j - 1);
        }

        return result;
    }
}
