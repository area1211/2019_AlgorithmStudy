package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no1937_욕심쟁이판다 {

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int n;
    static int[][] map = new int[500][500];
    static int[][] dp = new int[500][500];
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if(dp[i][j] == 0) {
                    dp[i][j] = DFS(i, j, 1);
                }

            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(max);
    }

    static int DFS(int r, int c, int depth) {
        if(dp[r][c] != 0) return dp[r][c];

        dp[r][c] = depth;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
            if (map[r][c] >= map[nr][nc]) continue;

            dp[r][c] = Math.max(dp[r][c], DFS(nr, nc, depth) + 1);
        }

        max = Math.max(max, dp[r][c]);
        return dp[r][c];
    }
}
