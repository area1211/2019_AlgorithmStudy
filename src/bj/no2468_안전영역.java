package bj;

import java.util.Scanner;

public class no2468_안전영역 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int map[][] = new int[101][101];
    static boolean visited[][] = new boolean[101][101];

    static boolean flag = true;
    static int rain = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }


        int cnt = 0;
        int max = 1;
        while(flag) {
            flag = false;
            init();
            cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j] + " ");
                    if(map[i][j] > rain && !visited[i][j]) {
                        flag = true;
                        DFS(i, j);
                        cnt++;
                    }

                }
//            System.out.println();
            }

            System.out.println(rain + ", " + cnt);
            if(max < cnt) max = cnt;

            rain++;

        }

        System.out.println(max);

    }

    static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
    }

    static void DFS(int i, int j) {

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];

            if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
            if (map[ni][nj] <= rain || visited[ni][nj]) continue;

            DFS(ni, nj);
        }
    }


}
