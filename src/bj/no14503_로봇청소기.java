package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14503_로봇청소기 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map = new int[50][50];

    static int N, M, cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(r, c, d);
        System.out.println(cnt);

    }

    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void DFS(int i, int j, int d) {
        if (map[i][j] == 0) {
            map[i][j] = 2; // 청소
            cnt++;
        }
//        System.out.println(i + ", " + j + ", " + d + " cnt:" + cnt);
//        print();

        int ni, nj;
        for (int k = 0; k < 4; k++) {
            d = (d + 3) % 4;
            ni = i + dy[d];
            nj = j + dx[d];

            if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
            if (map[ni][nj] == 0)
                DFS(ni, nj, d);
        }

        // 후진
        ni = i - dy[d];
        nj = j - dx[d];

        if (ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] != 1)
            DFS(ni, nj, d);
        else if (map[ni][nj] == 1) {
            System.out.println(cnt);
            System.exit(0);
        }

    }
}
