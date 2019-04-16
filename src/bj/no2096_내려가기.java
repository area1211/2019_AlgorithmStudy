package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2096_내려가기 {

    static int[][] map = new int[100000][3];
    static int[][] min = new int[100000][3];
    static int[][] max = new int[100000][3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            max[0][i] = min[0][i] = map[0][i];
        }

        for (int i = 1; i < N; i++) {
            min[i][0] = map[i][0] + Math.min(min[i - 1][0], min[i - 1][1]);
            min[i][1] = map[i][1] + Math.min(min[i][0] - map[i][0], min[i - 1][2]);
            min[i][2] = map[i][2] + Math.min(min[i - 1][1], min[i - 1][2]);


            max[i][0] = map[i][0] + Math.max(max[i - 1][0], max[i - 1][1]);
            max[i][1] = map[i][1] + Math.max(max[i][0] - map[i][0], max[i - 1][2]);
            max[i][2] = map[i][2] + Math.max(max[i - 1][1], max[i - 1][2]);
        }

        int maxScore = Math.max(max[N-1][0], Math.max(max[N-1][1], max[N-1][2]));
        int minScore = Math.min(min[N-1][0], Math.min(min[N-1][1], min[N-1][2]));

        System.out.println(maxScore + " " + minScore);
    }
}
