package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// TODO: 2019-03-29 : ~ing
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5VwAr6APYDFAWu&categoryId=AV5VwAr6APYDFAWu&categoryType=CODE&&&
public class no2105_디저트카페 {

    static int[] dr = {-1, 1, 1, -1};
    static int[] dc = {1, 1, -1, -1};
    static int[] distance;
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static LinkedList<Integer> dessertList;

    static int max = 0, sum = 0;
    static boolean isSuccessTour = false;
    static int originR, originC;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];


            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 1; j < N - 1; j++) {
                for (int k = 0; k < N - 2; k++) {

//                    visited = new boolean[N][N];

                    dessertList = new LinkedList<>();
                    distance = new int[4];

                    originR = j; originC = k;

                    tour(j, k, 0);
                    if (isSuccessTour) {
                        max = Math.max(max, dessertList.size());
                    }

                    isSuccessTour = false;
                    curDir = 0;
                }
            }

            if (max != 0) {;
                System.out.println("#" + i + " " + max);
            } else {
                System.out.println("#" + i + " " + -1);
            }


        }

    }

    static int curDir = 0;

    static void tour(int r, int c, int dist) {
//
//
//        if (dessertList.contains(map[r][c])) {
//            distance[curDir]--;
//            return;
//        }
        dessertList.add(map[r][c]);



        for (int i = 0; i < 2; i++) {
            int nr = r + dr[curDir + i];
            int nc = c + dc[curDir + i];

//            if (visited[nr][nc]) continue;

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if (nr == originR && nc == originC) {
                isSuccessTour = true;
                return;
            }
            if (i == 1 && dist == 0) continue; // 오른쪽으로 방향 전환 할 때


            if (i == 0 && !checkOppositePossible(curDir)) continue;
            if (dessertList.contains(map[nr][nc])) continue; // 이미 맛본 디저트

//            visited[nr][nc] = true;



            curDir = curDir + i;

            distance[curDir]++;
            tour(nr, nc, dist + 1);
            if (isSuccessTour) return;

        }


//        for (int i = 0; i < 4; i++) {
//
//            int nr = r + dr[i];
//            int nc = c + dc[i];
//
//            if (visited[nr][nc]) continue;
//            if (curDir != i && distance[i] == 0) continue;
//            if (nr < 0 || nc < 0 || nr > N || nc > N) continue;
//
//            if (checkOppositePossible(i)) continue;
//            if (dessertList.contains(map[nr][nc])) continue; // 이미 맛본 디저트
//
//            visited[nr][nc] = true;
//            distance[i]++;
//            tour(nr, nc, sum + map[nr][nc]);
//        }

    }

    static boolean checkOppositePossible(int curDir) {
        if (curDir == 0 || curDir == 1) return true;

        int oppositeDir = (curDir + 2) % 4;
        return distance[curDir] < distance[oppositeDir];
    }
}
