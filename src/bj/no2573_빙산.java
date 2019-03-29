package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2019-03-28
public class no2573_빙산 {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int R, C;
    static int year = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        while(true) {
            int cnt = 0;

            visited = new boolean[R + 1][C + 1];
            for (int i = 2; i < R; i++) {
                for (int j = 2; j < C; j++) {

                    if(!visited[i][j] && map[i][j] > 0) {
//                        dfsWithoutMelting(i, j);
                        dfs(i, j);
                        cnt++;
                    }

                }
            }

            print();

            if (cnt >= 2) break;
            else if (cnt == 0) {
                year = 0;
                break;
            }

            year++;
            System.out.println(year +"년 후...");
        }


        System.out.println(year);
    }

    static void dfs(int r, int c) {


        visited[r][c] = true;

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            map[r][c] += map[nr][nc] == 0 ? -1 : 0;
        }
        map[r][c] = map[r][c] == 0 ? -1 : map[r][c];

        print();

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(visited[nr][nc] || map[nr][nc] == 0) continue;

            dfs(nr, nc);
        }


        map[r][c] = map[r][c] <= 0 ? 0 : map[r][c];
    }

    static void print() {
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if(map[i][j] < 0) System.out.print(map[i][j] + " ");
                else System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
