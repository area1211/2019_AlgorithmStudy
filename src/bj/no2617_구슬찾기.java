package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: 2019-04-21
// no1613 역사 문제와 같이 플로이드 방법으로 해결할 수 있다.
// DFS로도 풀어보자.
public class no2617_구슬찾기 {
    static final int MAX = 987654321;
    static final int LIGHT = 0;
    static final int HEAVY = 1;
    static int[][] map = new int[100][100];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], MAX);
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = -1;
        }


        // 플로이드 방식
        for (int m = 1; m <= N; m++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {

                    if (map[i][m] == -1 && map[m][j] == -1) {
                        // i -> m -> j로 무겁다면
                        map[i][j] = -1;
                        map[j][i] = 1;
                    }

                }

            }
        }

        int lightMax = (N - 1) / 2;
        int heavyMax = N - (N + 1) / 2;

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int lightNum = 0, heavyNum = 0;
            for (int j = 1; j <= N; j++) {

                if(map[i][j] == -1)
                    heavyNum++;
                else if(map[i][j] == 1)
                    lightNum++;

            }
            if (lightNum > lightMax || heavyNum > heavyMax)
                answer++;
        }

        System.out.println(answer);
    }
}
