package bj.rethink;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// TODO: 2019-04-04
// 2차원 배열 복사할 때 deep copy 하는 것을 주의하자.
// 모든 조합에 대해 검사하지말고, 빈 칸에 대해서만 조합을 내서 BFS Or DFS를 실행하자.
public class no14502_연구소 {

    static final int SAFE = 0, WALL = 1, VIRUS = 2;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[][] map = new int[9][9];
    static int[][] testMap;
    static boolean[][] visited;
    static boolean[][] dp;

    static int N, M;
    static int maxSafeAreaCnt = 0;

    static LinkedList<Integer> emptyList = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    emptyList.add(M * (i - 1) + j);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
//        combination(list, N * M, 3, 0);
        combination(list, emptyList.size(), 3, 0);

        System.out.println(maxSafeAreaCnt);

    }

    static void print(int[][] printMap) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(printMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int BFS(int r, int c, int type) {
        LinkedList<Point> queue = new LinkedList<>();
        visited = new boolean[N + 1][M + 1];
        int cnt = 0;


//        if (type == SAFE) testMap[r][c] = 3;
//        cnt++;
        visited[r][c] = true;
        queue.add(new Point(r, c));

        while (queue.size() != 0) {
            Point p = queue.poll();
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 1 || nc < 1 || nr > N || nc > M) continue;
                if (visited[nr][nc]) continue;
                if (testMap[nr][nc] == WALL || testMap[nr][nc] == VIRUS) continue;

                if (type == VIRUS) testMap[nr][nc] = 2;
//                else {
//                    testMap[nr][nc] = 3;
//                }

//                cnt++;

                visited[nr][nc] = true;
                queue.add(new Point(nr, nc));
            }
        }

        return cnt;
    }

    public static int[][] deepCopyIntMatrix(int[][] input) {
        if (input == null)
            return null;
        int[][] result = new int[input.length][];
        for (int r = 0; r < input.length; r++) {
            result[r] = input[r].clone();
        }
        return result;
    }


    public static void combination(List<Integer> list, int length, int r, int pivot) {
        if (r == 0) {
//                for (int n : list) System.out.print(n + " ");
//                System.out.println();

//            testMap = Arrays.copyOf(map, map.length);
            testMap = deepCopyIntMatrix(map);
            dp = new boolean[N + 1][M + 1];
            if (convertRC(list) == true) {

                // 바이러스 퍼트리기
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= M; j++) {

                        if (testMap[i][j] == VIRUS)
                            BFS(i, j, VIRUS);

                    }
                }
//                System.out.println("After virus spread...");
//                print(testMap);

                // 안전영역 구하기
                int safeAreaCnt = 0;
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= M; j++) {

//                        if (testMap[i][j] == SAFE && !visited[i][j])
//                            safeAreaCnt += BFS(i, j, SAFE);

                        if (testMap[i][j] == 0)
                            safeAreaCnt++;

                    }
                }
//                System.out.println("Safe Area Count: " + safeAreaCnt);
//                System.out.println();
//                print(testMap);
                maxSafeAreaCnt = Math.max(maxSafeAreaCnt, safeAreaCnt);
            }
            return;
        }
        for (int i = pivot; i < length; i++) {
            list.add(emptyList.get(i));
//            list.add(i);
            combination(list, length, r - 1, i + 1);
            list.remove(list.size() - 1);
        }
    }

    static boolean convertRC(List<Integer> list) {
//        for (int n :
//                list) {
//
//            int r = n / M + 1;
//            int c = n % M + 1;
//            System.out.print("(" + r + ", " + c + ")");
//        }
//        System.out.println();
        for (int n :
                list) {

            int r = n / M + 1;
            int c = n % M + 1;
            if (testMap[r][c] == 0) {
                testMap[r][c] = 1;
            } else {
                return false;
            }
        }

        return true;
    }

//    static class Combination {
//
//        /**
//         * 리스트와 재귀를 이용한 조합 생성 * * @param list * @param length 집합의 개수 * @param r 선택하는 부분집합의 개수 * @param pivot 기준 위치
//         */
//        public static void combination(List<Integer> list, int length, int r, int pivot) {
//            if (r == 0) {
////                for (int n : list) System.out.print(n + " ");
////                System.out.println();
//                convertRC(list);
//                return;
//            }
//            for (int i = pivot; i < length; i++) {
//                list.add(i);
//                combination(list, length, r - 1, i + 1);
//                list.remove(list.size() - 1);
//            }
//        }
//
//        static void convertRC(List<Integer> list) {
//            for (int n :
//                    list) {
//
//                int r = n / 7 + 1;
//                int c = n % 7 + 1;
//                System.out.print("(" + r + ", " + c + ")");
//
//
//            }
//            System.out.println();
//        }
//
//        /**
//         * for 문을 이용한 조합
//         */
//        public static void combi_for() {
//            for (int i = 0; i < 3; i++) {
//                for (int j = i + 1; j < 3; j++) {
//                    System.out.printf("%d %d\n", i, j);
//                }
//            }
//        }
//    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
