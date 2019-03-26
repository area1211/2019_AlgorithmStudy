package bj.fail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// TODO: 2019-03-21 다시 풀어볼 것 
public class no14501_퇴사 {

    static int[] T = new int[16];
    static int[] P = new int[16];
    static int[] dp = new int[16];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());

            dp[i] = P[i];
        }


        for (int i = 1; i <= N; i++) {

//            int today = P[i];
//            if (i + T[i] - 1 > N) today = 0;

            for (int j = 1; j < i; j++) {
                if (i - j >= T[j])
                    dp[i] = Math.max(dp[i], dp[j] + P[i]);
            }

        }


        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (i + T[i] - 1 <= N) max = Math.max(max, dp[i]);
        }

        System.out.print(max);
    }
}
