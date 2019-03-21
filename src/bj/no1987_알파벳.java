package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2019-03-21  
public class no1987_알파벳 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int R, C;
    static char[][] map = new char[21][21];
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
//                System.out.println((int)map[i][j] - 65);
            }
        }

        visited[(int)map[0][0] - 65] = true;
        System.out.println(DFS(0, 0));
    }

    static int DFS(int i, int j) {



        int max = 0;

        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];


            if (ni < 0 || nj < 0 || ni >= R || nj >= C) continue;
            if (visited[(int)map[ni][nj] - 65]) continue;

            visited[(int)map[ni][nj] - 65] = true;
            max = Math.max(max, DFS(ni, nj));
            visited[(int)map[ni][nj] - 65] = false;
        }

        return max + 1;
    }
}
