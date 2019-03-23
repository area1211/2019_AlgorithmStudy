package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// TODO: 2019-03-22
public class no7562_나이트의이동 {

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static boolean[][] visited = new boolean[300][300];

    static int l;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            l = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startI = Integer.parseInt(st.nextToken());
            int startJ = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endI = Integer.parseInt(st.nextToken());
            int endJ = Integer.parseInt(st.nextToken());

            System.out.println(BFS(startI, startJ, endI, endJ));
            for (int j = 0; j < 300; j++) {
                for (int k = 0; k < 300; k++) {
                    visited[j][k] = false;
                }
            }
        }

    }

    static int BFS(int i, int j, int endI, int endJ) {

        LinkedList<Position> queue = new LinkedList<>();

        visited[i][j] = true;
        queue.add(new Position(i , j, 0));

        while(queue.size() != 0) {
            Position p = queue.poll();

            if (p.i == endI && p.j == endJ) return p.d;

            for (int k = 0; k < 8; k++) {
                int ni = p.i + dy[k];
                int nj = p.j + dx[k];
                int nd = p.d + 1;

                if(ni < 0 || nj < 0 || ni >= l || nj >= l) continue;
                if(visited[ni][nj]) continue;

                visited[ni][nj] = true;
                queue.add(new Position(ni, nj, nd));
            }

        }

        return 0;
    }
}

class Position {
    int i, j, d;

    Position(int i, int j, int d) {
        this.i = i; this.j = j; this.d = d;
    }
}