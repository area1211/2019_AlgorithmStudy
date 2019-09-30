package bj.rethink;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no17136_색종이붙이기 {

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[][] map = new int[11][11];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }

    static void test(int r, int c) {

        int length = 1;
        for (int i = 1; c + i <= 10 && map[r][c + i] == 1; i++) {
            length++;
        }

        for (int i = 1; r - i >= 1 && map[r - i][c] == 1; i++) {

        }


    }
}
