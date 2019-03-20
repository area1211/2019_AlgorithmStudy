package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// TODO: 2019-03-20
/*
cost(I, J) : I 번째 집을 J로 칠하는데 드는 최소 비용
cost(I, R) = min( cost(I-1, G), cost(I-1, B) )
cost(I, G) = min( cost(I-1, R), cost(I-1, B) )
cost(I, B) = min( cost(I-1, R), cost(I-1, G) )
cost(I) : I 번째 집을 칠할 때 드는 비용의 최솟값
cost(I) = min( cost(I,R), cost(I, G), cost(I, B) )
 */
public class no1149_RGB거리 {

    static int N;
//    static int[][] cost = new int[1000][3];
    static int[][] minCost = new int[1001][3];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
//            String[] str = br.readLine().split(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            minCost[i][0] = Integer.parseInt(st.nextToken()) + Math.min(minCost[i - 1][1], minCost[i - 1][2]);
            minCost[i][1] = Integer.parseInt(st.nextToken()) + Math.min(minCost[i - 1][0], minCost[i - 1][2]);
            minCost[i][2] = Integer.parseInt(st.nextToken()) + Math.min(minCost[i - 1][0], minCost[i - 1][1]);

//            minCost[i][0] = Integer.parseInt(str[0]) + Math.min(minCost[i - 1][1], minCost[i - 1][2]);
//            minCost[i][1] = Integer.parseInt(str[1]) + Math.min(minCost[i - 1][0], minCost[i - 1][2]);
//            minCost[i][2] = Integer.parseInt(str[2]) + Math.min(minCost[i - 1][0], minCost[i - 1][1]);
//            for (int j = 0; j < 3; j++) {
//                minCost[i][j] = Integer.parseInt(str[j]) + Math.min(minCost[i - 1][(j + 1) % 3], minCost[i - 1][(j + 2) % 3]);
//            }
        }

//        minCost[0][0] = cost[0][0];
//        minCost[0][1] = cost[0][1];
//        minCost[0][2] = cost[0][2];
//
//        for (int i = 1; i < N; i++) {
//            for (int j = 0; j < 3; j++) {
//                minCost[i][j] = cost[i][j] + Math.min(minCost[i - 1][(j + 1) % 3], minCost[i - 1][(j + 2) % 3]);
//            }
//        }

        int result = Math.min(minCost[N][0], Math.min(minCost[N][1], minCost[N][2]));
        System.out.print(result);
    }
}
