package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// TODO: 2019-04-14
public class no11559_PuyoPuyo {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static char[][] map = new char[12][6];
    static LinkedList<Character>[] mapList = new LinkedList[6];
    static LinkedList<Point> puyoQueue = new LinkedList<>();
    static LinkedList<Point> history = new LinkedList<>();
    static LinkedList<Point> listToRemove = new LinkedList<>();
    static int answer = 0;

    static boolean[][] visited = new boolean[12][6];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 6; i++) {
            mapList[i] = new LinkedList<>();
        }

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                char c = str.charAt(j);
                mapList[j].addFirst(c);
                if (c != '.') {
                    puyoQueue.add(new Point(11 - i, j));
                }

            }
        }

        while (true) {
            while (!puyoQueue.isEmpty()) {
                Point p = puyoQueue.poll();
                if (BFS(p.r, p.c)) {
                    listToRemove.addAll(history);
                }
                history.clear();
            }

            // 터질 뿌요가 없으면 게임 종료
            if (listToRemove.isEmpty()) break;

            // 터질 뿌요가 있기 때문에 1연쇄 추가
            answer++;
            // 뿌요를 터뜨리고 위치 재조정
            while (!listToRemove.isEmpty()) {
                Point p = listToRemove.poll();
                mapList[p.c].set(p.r, '.');
            }

            for (int i = 0; i < 6; i++) {
//                List<Character> temp = mapList[i].stream()
//                        .filter( c -> c != '.' )
//                        .collect(Collectors.toList());
//
//                mapList[i].clear();
//                mapList[i].addAll(temp);

                mapList[i].removeIf(c -> c == '.');

                int size = mapList[i].size();
                for (int j = 0; j < 12 - size; j++) {
                    mapList[i].add('.');
                }

//                SingleLinkedList<Character> tempList = new SingleLinkedList<>();
//                for (int j = 0; j < 12; j++) {
//                    if (mapList[i].get(j) != '.') {
//                        tempList.addLast(mapList[i].get(j));
//                    }
//                }
//
//                int tempSize = tempList.size();
//                for (int j = 0; j < 12 - tempSize; j++) {
//                    tempList.addLast('.');
//                }
//
//                mapList[i] = tempList;
            }

//            System.out.println("위치 조정 후...");
//            print();
//            System.out.println();

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 12; j++) {
                    if (mapList[i].get(j) != '.') {
                        puyoQueue.add(new Point(j, i));
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static boolean BFS(int r, int c) {
        if (mapList[c].get(r) == '.') return false;
        LinkedList<Point> queue = new LinkedList<>();

        boolean[][] visited = new boolean[12][6];

        visited[r][c] = true;
        queue.add(new Point(r, c));
        history.add(new Point(r, c));

        int cnt = 1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {

                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= 12 || nc >= 6) continue;
                if (visited[nr][nc] || mapList[p.c].get(p.r) != mapList[nc].get(nr)) continue;

                cnt++;
                visited[nr][nc] = true;
                queue.add(new Point(nr, nc));
                history.add(new Point(nr, nc));
            }

        }

        return cnt >= 4;
    }

    static void print() {
        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                System.out.print(mapList[j].get(i));
            }
            System.out.println();
        }
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
