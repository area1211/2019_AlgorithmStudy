package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

// TODO: 2019-04-13  
public class no15685_드래곤커브 {

    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};

    static boolean[][] map = new boolean[101][101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            LinkedList<Integer> list = new LinkedList<>();
            map[y][x] = true; // 시작점
            y = y + dr[d];
            x = x + dc[d];
            map[y][x] = true; // 0세대 그리기.
            list.add(d);

            for (int j = 1; j <= g; j++) {

                int listSize = list.size();
                for (int k = listSize - 1; k >= 0; k--) {
                    int nowD = list.get(k);
                    int nextD = (nowD + 1) % 4;

                    y = y + dr[nextD];
                    x = x + dc[nextD];
                    map[y][x] = true;

                    list.add(nextD);
                }

            }
//            System.out.println();
//            print();
//            System.out.println();
        }

        // 사각형 갯수 세기
        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static void print() {
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
