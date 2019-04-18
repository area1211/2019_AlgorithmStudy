package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no6593_상범빌딩 {
    static int[] dr = {1, 0, -1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};
    static int[] dl = {0, 0, 0, 0, 1, -1};

    static int L, R, C;
    static char[][][] map = new char[31][31][31];
    static boolean[][][] visited = new boolean[31][31][31];
    static Point startP, endP;

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L + R + C == 0) break; // 종료 조건

            for (int i = 1; i <= L; i++) {
                for (int j = 1; j <= R; j++) {
                    String str = br.readLine();
                    for (int k = 1; k <= C; k++) {
                        map[i][j][k] = str.charAt(k - 1);
                        if (map[i][j][k] == 'S')
//                            startP = new Point(i, j, k);
                            startP = new Point(i, j, k, 0);
                        else if (map[i][j][k] == 'E')
                            endP = new Point(i, j, k);
                    }
                }
                br.readLine();
            }

//            DFS(startP, 0);
            BFS(startP);
            if (answer == 0) {
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in ");
                sb.append(answer);
                sb.append(" minute(s).\n");
            }

            init();
        }

        System.out.println(sb.toString());

    }

    static void init() {
        answer = 0;
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= R; j++) {
                for (int k = 1; k <= C; k++) {
                    visited[i][j][k] = false;
                }
            }
        }
    }

    static void DFS(Point s, int depth) {
        visited[s.l][s.r][s.c] = true;
        if (s.equals(endP)) {
            answer = depth;
            return;
        }


        for (int i = 0; i < 6; i++) {
            int nl = s.l + dl[i];
            int nr = s.r + dr[i];
            int nc = s.c + dc[i];

            if (!isInRange(nl, nr, nc) || visited[nl][nr][nc]) continue;

            DFS(new Point(nl, nr, nc), depth + 1);
        }
    }

    static void BFS(Point s) {
        LinkedList<Point> queue = new LinkedList<>();

        visited[s.l][s.r][s.c] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if(map[p.l][p.r][p.c] == 'E') {
                answer = p.depth;
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nl = p.l + dl[i];
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (!isInRange(nl, nr, nc) || visited[nl][nr][nc]) continue;

                visited[nl][nr][nc] = true;
                queue.add(new Point(nl, nr, nc, p.depth + 1));
            }
        }
    }

    static boolean isInRange(int l, int r, int c) {
        return l >= 1 && l <= L && r >= 1 && r <= R && c >= 1 && c <= C && map[l][r][c] != '#';
    }

    static class Point {
        int l, r, c, depth;

        public Point(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }

        public Point(int l, int r, int c, int depth) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.depth = depth;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Point)) return false;

            Point p = (Point) o;
            return l == p.l && r == p.r && c == p.c;
        }
    }
}
