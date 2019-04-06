package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// TODO: 2019-04-06  
public class no1890_점프 {
    static int[] dr = {1, 0};
    static int[] dc = {0, 1};
    static int[][] map = new int[101][101];
    static long[][] dp = new long[101][101];
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == N && j == N) break;
                int n = map[i][j];

                if (i + n <= N)
                    dp[i + n][j] += dp[i][j];
                if (j + n <= N)
                    dp[i][j + n] += dp[i][j];
            }
        }

        System.out.println(dp[N][N]);


    }

}
