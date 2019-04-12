package bj.fail;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// TODO: 2019-04-12
public class no1309_동물원 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][N + 1];


        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
            dp[i][1] = i * 2;


            for (int j = 2; j <= i; j++) {


                for (int k = 1; j - k >= 0; k++) {

                    dp[i][j] += (int)Math.pow(-1, k-1) * 2 * dp[i - k][j - k];

                }

                dp[i][j] += dp[i-1][j];

            }


            dp[i][i] = 2;
        }


        int answer = 0;
        for (int i = 0; i <= N; i++) {
//            System.out.println("dp[" + N + "][" + i + "] = " + dp[N][i]);
            answer += dp[N][i];
        }
        System.out.println(answer);
    }
}
