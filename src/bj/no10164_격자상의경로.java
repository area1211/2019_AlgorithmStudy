package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2019-04-22  
public class no10164_격자상의경로 {
    static int[][] dp = new int[15][15];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int answer;
        if (K == 0 || K == 1) {
            answer = dp(N - 1, M - 1);
        } else {
            int i = (K - 1) / M, j = (K - 1) % M;
            answer = dp(i, j) * dp(N - i - 1, M - j - 1);
        }

        System.out.println(answer);
    }

    static int dp(int r, int c) {
        if (r == 0 && c == 0) return 0;
        else if (r == 0 || c == 0) return 1;
        else if (dp[r][c] != 0) return dp[r][c];

        dp[r][c] = dp(r - 1, c) + dp(r, c - 1);
        return dp[r][c];
    }
}
