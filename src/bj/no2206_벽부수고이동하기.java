package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// TODO: 2019-04-19  
public class no2206_벽부수고이동하기 {

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, M;
    static int[][] map = new int[1001][1001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {

                map[i][j] = Integer.parseInt(str.charAt(j - 1) + "");

            }
        }

        int a = bfs(1, 1);
        System.out.println(a);
    }

    static int bfs(int r, int c) {
        boolean[][] visited = new boolean[1001][1001];
        boolean[][] visitedCrash = new boolean[1001][1001];
        LinkedList<Point> queue = new LinkedList<>();


        visited[r][c] = true;
        queue.add(new Point(r, c, 1, false));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.r == N && p.c == M) {
                return p.depth;
            }


            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 1 || nc < 1 || nr > N || nc > M) continue;
//                if (visited[nr][nc]) continue;

                boolean isWall = (map[nr][nc] == 1);
                if (isWall && p.isCrash) continue; // 벽이고 이미 다른 벽을 부수고 왔으면

                if (p.isCrash) {
                    if (visitedCrash[nr][nc]) continue;
                    visitedCrash[nr][nc] = true;
                }
                else {
                    if (visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                }

                queue.add(new Point(nr, nc, p.depth + 1, isWall || p.isCrash));
            }
        }

        return -1;
    }

    static class Point {
        int r, c, depth;
        boolean isCrash;

        public Point(int r, int c, int depth, boolean isCrash) {
            this.r = r;
            this.c = c;
            this.depth = depth;
            this.isCrash = isCrash;
        }
    }
}
