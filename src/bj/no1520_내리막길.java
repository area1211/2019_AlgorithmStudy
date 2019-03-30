package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2019-03-30
// [DP]no1520 내리막길 성공
// 방문 표시를 하지 않았을 때 이미 방문한 곳까지 다시 탐색을 하므로 시간초과가 났던 것 같다.
// 방문 표시를 위해 Dp 배열을 -1로 초기화 하고 방문 했을 경우 0으로 변경해줌으로써 해결됐다.
public class no1520_내리막길 {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int R, C;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        dp = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        dp(0, 0);

        print();

        System.out.println(dp[0][0]);
    }

    static void dp(int r, int c) {

        if (r == R-1 && c == C-1){
            dp[r][c] = 1;
            print();
            return;
        }

        if (dp[r][c] == -1) dp[r][c] = 0; // 방문 표시


        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr > R-1 || nc > C-1) continue;
            if (dp[nr][nc] >= 0) {
                dp[r][c] += dp[nr][nc];
                print();
                continue;
            }

            if (map[r][c] <= map[nr][nc]) continue;

            dp(nr, nc);
            dp[r][c] += dp[nr][nc];
            print();
        }
    }

    static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
