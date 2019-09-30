package bj.rethink;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2019-04-18
// 왼쪽, 위, 왼쪽대각선 위 값의 최솟값 + 1이 만들 수 있는 정사각형 한 변의 길이이다.
public class no1915_가장큰정사각형 {
    static int[][] map;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        map = new int[n + 1][m + 1];


        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = str.charAt(j - 1) - 48;
                if (map[i][j] == 1) {
                    map[i][j] = Math.min(map[i - 1][j], Math.min(map[i - 1][j - 1], map[i][j - 1])) + 1;
                    max = Math.max(max, map[i][j]);
                }
            }
        }


//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                if (map[i][j] == 1) {
//                    map[i][j] = Math.min(map[i - 1][j], Math.min(map[i - 1][j - 1], map[i][j - 1])) + 1;
//                    max = Math.max(max, map[i][j]);
//                }
//            }
//        }

        System.out.println(max * max);


    }
}
