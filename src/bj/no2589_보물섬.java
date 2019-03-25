package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no2589_보물섬 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int R, C;
    static int max = 0;
    static char[][] map = new char[50][50];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    BFS(i, j);
                }
            }
        }

        System.out.println(max);
    }

    static void BFS(int i, int j) {
        boolean[][] visited = new boolean[50][50];
        LinkedList<PointTest> queue = new LinkedList<>();

        visited[i][j] = true;
        queue.add(new PointTest(i, j, 0));

        while(queue.size() != 0) {
            PointTest p = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ni = p.i + dy[k];
                int nj = p.j + dx[k];

                if(ni < 0 || nj <0 || ni >= R || nj >= C) continue;
                if(map[ni][nj] == 'W' || visited[ni][nj]) continue;

                visited[ni][nj] = true;
                max = Math.max(max, p.d + 1);
                queue.add(new PointTest(ni, nj, p.d + 1));

            }
        }


    }
}

class PointTest {
    int i, j, d;
    PointTest(int i, int j, int d) {
        this.i = i;
        this.j = j;
        this.d = d;
    }
}