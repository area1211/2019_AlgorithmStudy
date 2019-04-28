package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2019-04-28
// no11066 파일합치기와 유사한 문제 같다.
public class no11049_행렬곰셈순서 {
    static final int MAX_VAL = 987654321;

    static int[][] mat = new int[501][2];
    static int[][] dp = new int[501][501];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            mat[i][0] = r;
            mat[i][1] = c;
        }

        for (int i = 1; i <= 500; i++) {
            for (int j = 1; j <= 500; j++) {
                dp[i][j] = MAX_VAL;
            }
        }


        System.out.println(dp(1, N));
    }

    static int dp(int tx, int ty) {
        if (dp[tx][ty] != MAX_VAL)
            return dp[tx][ty];

        if (tx == ty) {
            dp[tx][ty] = 0;
            return dp[tx][ty]; // 자기 자신부터 자기 자신까지는 합치는 비용이 없으므로 0을 return.
        }
        if (tx + 1 == ty) {
            dp[tx][ty] = mat[tx][0] * mat[tx][1] * mat[ty][1]; // 바로 옆에 붙어 있으면 N * M * K
            return dp[tx][ty];
        }

        for (int mid = tx; mid < ty; mid++) {

            int left = dp(tx, mid);
            if (left == 0)
                left = mat[tx][0] * mat[tx][1] * mat[ty][1];

            int right = dp(mid + 1, ty);
            if (right == 0)
                right = mat[tx][0] * mat[ty][0] * mat[ty][1];

            dp[tx][ty] = Math.min(dp[tx][ty], left + right);
        }

        return dp[tx][ty];
    }
}
