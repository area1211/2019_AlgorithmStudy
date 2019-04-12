package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no3055_탈출 {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int R, C;
    static char[][] map = new char[51][51];
    static boolean[][] visited = new boolean[51][51];
    static int curI, curJ;
    static int targetI, targetJ;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j + 1] = str.charAt(j);
                if (map[i][j + 1] == 'S') {
                    curI = i;
                    curJ = j + 1;
                } else if (map[i][j + 1] == 'D') {
                    targetI = i;
                    targetJ = j + 1;
                }
            }
        }


        BFS(curI, curJ);
        if (max > 0) {
            System.out.println(max);
        } else {
            System.out.println("KAKTUS");
        }

    }

    static void print(char[][] map) {
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static void BFS(int r, int c) {
        LinkedList<Point> queue = new LinkedList<>();

        visited[r][c] = true;
        queue.add(new Point(r, c, 0));


        while (queue.size() != 0) {



            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {

                Point p = queue.poll();
                if (p.r == targetI && p.c == targetJ) { // 비버의 소굴에 도착하면 걸린 시간을 리턴한다.
                    max = Math.max(max, p.time);
                }

//                System.out.println("현재 맵 : " +p.r + ", " + p.c + ", time = " + p.time);
//                print(map);

                for (int i = 0; i < 4; i++) {
                    int nr = p.r + dr[i];
                    int nc = p.c + dc[i];

                    // 범위 체크
                    if (nr < 1 || nc < 1 || nr > R || nc > C) continue;
                    // 돌 체크, 물체크
                    if (map[nr][nc] == 'X' || map[nr][nc] == '*') continue;
                    // 다음 시간에 물이 찰 예정인 칸인지 체크
                    boolean waterFlag = false;
                    for (int j = 0; j < 4; j++) {
                        int nr2 = nr + dr[j];
                        int nc2 = nc + dc[j];
                        if (nr2 < 1 || nc2 < 1 || nr2 > R || nc2 > C) continue;

                        if (map[nr][nc] != 'D' && map[nr2][nc2] == '*') {
                            waterFlag = true;
                        }
                    }
                    if (waterFlag) continue;

                    // 방문 했는지 체크
                    if (visited[nr][nc]) continue;
                    visited[nr][nc] = true;


                    queue.add(new Point(nr, nc, p.time + 1));
                }

            }


            // 물 퍼뜨리기
            LinkedList<Point> waterQueue = new LinkedList<>();
            for (int j = 1; j <= R; j++) {
                for (int k = 1; k <= C; k++) {
                    if (map[j][k] == '*') { // 물 있는 곳을 확인해서 큐에 넣기
                        waterQueue.add(new Point(j, k));
                    }
                }
            }

            int waterSize = waterQueue.size();
            for (int i = 0; i < waterSize; i++) {
                Point waterP = waterQueue.poll();
                for (int k = 0; k < 4; k++) {
                    int nr2 = waterP.r + dr[k];
                    int nc2 = waterP.c + dc[k];

                    if (nr2 < 1 || nc2 < 1 || nr2 > R || nc2 > C) continue;
                    // 돌, 비버, 비버의 소굴은 물로 채울 수 없다.
                    if (map[nr2][nc2] == 'X' || map[nr2][nc2] == 'D') continue;
                    map[nr2][nc2] = '*';
                }
            }


//            System.out.println("다음 시간의 맵 : " + (p.time + 1));
//            print(map);

        }


    }

    static class Point {
        int r, c, time;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}
