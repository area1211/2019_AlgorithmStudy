package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class no6359_만취한상범 {

    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int n = Integer.parseInt(br.readLine());
            dp = new int[n + 1];

            for (int j = 1; j <= n; j++) {
                for (int k = 1; j * k <= n; k++) {
                    dp[j * k] = (dp[j * k] + 1) % 2;
                }
//                for (int k = 1; k <= n; k++) {
//                    System.out.print(dp[k]);
//                }
//                System.out.println();
            }

            int answer = 0;
            for (int j = 1; j <= n; j++) {
                answer += dp[j];
            }

            System.out.println(answer);

        }

    }

    static int getNumberOfDivisor(int n) {
        int cnt = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                cnt++;
                if (i * i < n) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
