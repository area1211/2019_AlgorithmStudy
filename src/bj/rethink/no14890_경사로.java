package bj.rethink;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14890_경사로 {

    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());


        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int answer = 0;
        for (int i = 1; i <= N; i++) {
            /* 행 */
            int current = 1;
            boolean isOk = true;
            boolean[] stair = new boolean[N + 1];
            while (current < N && isOk) {

                if (map[i][current] == map[i][current + 1]) current++;
                else if (map[i][current] > map[i][current + 1]) {
                    int test;
                    for (test = 1; test <= L; test++) {
                        if (current + test > N || stair[current + test] ||  map[i][current + test] + 1 != map[i][current]) break;
                    }

                    if (test - 1 == L) { // 계단 가능
                        for (int j = 1; j <= L; j++) {
                            stair[current + j] = true;
                        }
                        current += test - 1;
                        continue;
                    } else {
                        isOk = false;
                    }

                } else {
                    int test;
                    for (test = 0; test < L; test++) {
                        if (current - test < 1 || stair[current - test] || map[i][current - test] + 1 != map[i][current + 1]) break;
                    }

                    if (test == L) { // 계단 가능
                        for (int j = 0; j < L; j++) {
                            stair[current - j] = true;
                        }
                        current += 1;
                        continue;
                    } else {
                        isOk = false;
                    }

                }
            }

            if (current >= N) {
//                System.out.println(i + "행 가능");
                answer++;
            }

            /* 열 */

            stair = new boolean[N + 1];
            current = 1;
            isOk = true;
            while (current < N && isOk) {

                if (map[current][i] == map[current + 1][i]) current++;
                else if (map[current][i] > map[current + 1][i]) {
                    int test;
                    for (test = 1; test <= L; test++) {
                        if (current + test > N || stair[current + test] || map[current + test][i] + 1 != map[current][i]) break;
                    }

                    if (test - 1 == L) { // 계단 가능
                        for (int j = 1; j <= L; j++) {
                            stair[current + j] = true;
                        }
                        current += test - 1;
                        continue;
                    } else {
                        isOk = false;
                    }

                } else {
                    int test;
                    for (test = 0; test < L; test++) {
                        if (current - test < 1 || stair[current - test] || map[current - test][i] + 1 != map[current + 1][i]) break;
                    }

                    if (test == L) { // 계단 가능
                        for (int j = 0; j < L; j++) {
                            stair[current - j] = true;
                        }
                        current += 1;
                        continue;
                    } else {
                        isOk = false;
                    }

                }
            }

            if (current >= N) {
//                System.out.println(i + "열 가능");
                answer++;
            }
        }

        System.out.println(answer);

    }
}
