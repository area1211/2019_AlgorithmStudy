package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class no1012_유기농배추 {
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int T, M, N, K;
    static int[][] map = new int[51][51];
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- != 0) {
            String str[] = br.readLine().split(" ");
            M = Integer.parseInt(str[0]);
            N = Integer.parseInt(str[1]);
            K = Integer.parseInt(str[2]);

            for (int i = 0; i < K; i++) {
                str = br.readLine().split(" ");
                map[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 1) {
                        DFS(i, j);
                        cnt++;
                    }
                }
            }

            bw.write(cnt + "\n");
        }
        bw.flush();
    }

    static void DFS(int i, int j) {

        map[i][j] = 0;

        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];

            if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
            if (map[ni][nj] == 0) continue;

            DFS(ni, nj);
        }

    }
}
