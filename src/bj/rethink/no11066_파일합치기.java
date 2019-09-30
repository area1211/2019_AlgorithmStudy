package bj.rethink;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2019-04-18
public class no11066_파일합치기 {
    static final int MAX_VAL = 987654321;
    static int[] fileSize = new int[501];
    static int[][] dp = new int[501][501];
    static int[] sum = new int[501];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= K; j++) {
                fileSize[j] = Integer.parseInt(st.nextToken());
                sum[j] = sum[j - 1] + fileSize[j];
            }


            for (int j = 1; j <= K; j++) {
                for (int k = 1; k <= K; k++) {
                    dp[j][k] = MAX_VAL;
                }
            }


//            sb.append(dp[K - 1] + "\n");
            sb.append(dp(1, K) + "\n");
        }

        System.out.println(sb.toString());
    }


    static int dp(int tx, int ty) {
        if (dp[tx][ty] != MAX_VAL)
            return dp[tx][ty];

        if (tx == ty) {
            dp[tx][ty] = 0;
            return dp[tx][ty]; // 자기 자신부터 자기 자신까지는 합치는 비용이 없으므로 0을 return.
        }
        if (tx + 1 == ty) {
            dp[tx][ty] = fileSize[tx] + fileSize[ty]; // 바로 옆에 붙어 있으면 서로 더해서 return.
            return dp[tx][ty];
        }

        for (int mid = tx; mid < ty; mid++) {

            int left = dp(tx, mid);
            int right = dp(mid + 1, ty);

            dp[tx][ty] = Math.min(dp[tx][ty], left + right);
        }
        dp[tx][ty] += sum[ty] - sum[tx - 1];
        return dp[tx][ty];
    }
}
