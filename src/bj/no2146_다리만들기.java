package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// TODO: 2019-04-06  
public class no2146_다리만들기 {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
    static boolean[][] queueAdded = new boolean[101][101];
    static int N;
    static boolean isBridge = false;
    static int MIN_LENGTH = Integer.MAX_VALUE;
    static int cur_length = 0;

    static LinkedList<Point> queue = new LinkedList<>();
    static int landNum = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    DFS(i, j);
                    landNum++;
//                    printMap();
//                    System.out.println(queue.size());
                }
            }
        }

        for (Point p :
                queue) {
            BFS(p.r, p.c);
        }

//        print();
        System.out.println(MIN_LENGTH);
    }

    static void print() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                if (visited[i][j]) {
                    System.out.print("o ");
                } else {
                    System.out.print("x ");
                }
            }
            System.out.println();
        }
    }

    static void printMap() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void DFS(int r, int c) {
        map[r][c] = landNum;
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 1 || nc < 1 || nr > N || nc > N) continue;
            if (visited[nr][nc]) continue;


            if (map[r][c] == landNum && map[nr][nc] == 0 && !queueAdded[r][c]) {
                queueAdded[r][c] = true;
                queue.add(new Point(r, c));
                continue;
            }

            if (map[nr][nc] == 0) continue;
            DFS(nr, nc);
        }
    }

    static void BFS(int r, int c) {
        boolean[][] visited = new boolean[N + 1][N + 1];
        Point firstP = new Point(r, c);

        LinkedList<Point> queue = new LinkedList<>();

        visited[r][c] = true;
        queue.add(new Point(r, c, 0));

        while (queue.size() != 0) {
            Point p = queue.poll();
            if (map[p.r][p.c] != 0 && map[p.r][p.c] != map[firstP.r][firstP.c]) {
                MIN_LENGTH = Math.min(MIN_LENGTH, p.d);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 1 || nc < 1 || nr > N || nc > N) continue;
                if (visited[nr][nc]) continue;

                visited[nr][nc] = true;
                int nextLength = p.d;
                if(map[nr][nc] == 0) {
                    nextLength++;
                }
                queue.add(new Point(nr, nc, nextLength));
            }
        }
    }

    static class Point {
        int r, c, d;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Point(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }

        @Override
        public String toString() {
            return "(" + r + ", " + c + ") ";
        }
    }
}
