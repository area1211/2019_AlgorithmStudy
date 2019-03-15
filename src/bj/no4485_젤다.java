package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no4485_젤다 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;
    static int map[][] = new int[126][126];
    static boolean[][] visited = new boolean[126][126];
    static int[][] minDistance = new int[126][126];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int testCase = 0;

        while (N != 0) {
            testCase++;

            for (int i = 0; i < N; i++) {
//                String[] str = br.readLine().split(" ");
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    minDistance[i][j] = Integer.MAX_VALUE;
                }
            }

            BFS(0, 0);

            System.out.println("Problem " + testCase + ": " + minDistance[N-1][N-1]);
            N = Integer.parseInt(br.readLine());
        }

    }

    static void init() {
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                minDistance[i][j] = Integer.MAX_VALUE;
            }

        }
        minDistance[0][0] = map[0][0];

    }
    static void solution(int i, int j) {
        int minI = i, minJ = j;

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];

            if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
            if (visited[ni][nj]) continue;

            if (minDistance[ni][nj] > minDistance[i][j] + map[ni][nj]) {
                minDistance[ni][nj] = Integer.min(minDistance[ni][nj], minDistance[i][j] + map[ni][nj]);
                minI = ni; minJ = nj;
            }

        }
        if (minI == i && minJ == j) return;
        solution(minI, minJ);



    }

    static void BFS(int i, int j) {
        PriorityQueue<Point> queue = new PriorityQueue<>();

//        visited[i][j] = true;
        minDistance[i][j] = map[i][j];
        queue.add(new Point(i, j, minDistance[i][j]));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (minDistance[p.i][p.j] < p.d) continue;

            for (int k = 0; k < 4; k++) {
                int ni = p.i + dx[k];
                int nj = p.j + dy[k];

                if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
//                if (visited[ni][nj]) continue;


                if (minDistance[ni][nj] > minDistance[p.i][p.j] + map[ni][nj]) {
                    minDistance[ni][nj] = minDistance[p.i][p.j] + map[ni][nj];
                    queue.add(new Point(ni, nj, minDistance[ni][nj]));

//                    visited[ni][nj] = true;
                }
            }
        }
    }

}

class Point implements Comparable<Point>{
    int i, j, d;

    public Point(int i, int j, int d) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(Point target) {
        return this.d < target.d ? 1 : -1;
    }
}
