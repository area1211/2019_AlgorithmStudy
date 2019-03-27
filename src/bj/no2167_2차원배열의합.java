package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2019-03-27
public class no2167_2차원배열의합 {

    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];

        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()), j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

            int answer = dp[x][y] - dp[i-1][y] - dp[x][j-1] + dp[i-1][j-1];

            System.out.println(answer);
        }

//        for (int i = 0; i < K; i++) {
//            int sum = 0;
//            for (int j = position[i][0]; j <= position[i][2]; j++) {
//                for (int k = position[i][1]; k <= position[i][3]; k++) {
//                    sum += arr[j][k];
//                }
//            }
//            System.out.println(sum);
//        }


//        for (int i = 0; i < K; i++) {
//            System.out.println(answer(position[i][0], position[i][1], position[i][2], position[i][3]));
//        }

    }

    static int answer(int i, int j, int x, int y) {
        // = dp(x,y) - dp(i-1, y) - dp(x,j-1) + dp(i-1, j-1)

        return dp(x, y) - dp(i - 1, y) - dp(x, j - 1) + dp(i - 1, j - 1);
    }

    static int dp(int i, int j) {
        // dp(i, j) = dp(i-1,j) + dp(i,j-1) - dp(i-1,j-1) + arr(i,j)
        if (i < 1 || j < 1) return 0;

        return dp(i - 1, j) + dp(i, j - 1) - dp(i - 1, j - 1) + arr[i][j];
    }
}
