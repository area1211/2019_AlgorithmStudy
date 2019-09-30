package others.ebay;

import java.util.LinkedList;
import java.util.Queue;

public class p3 {
    public static void main(String[] args) {
        int[][] city = {{0, 0, 1}, {1, 1, 1}, {0, 1, 1}};

        new p3().solution(city);
    }

    private static int[] di = {1, 0, -1, 0};
    private static int[] dj = {0, 1, 0, -1};

    public int[][] solution(int[][] city){
        int r = city.length;
        int c = city[0].length;

        int[][] answer = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if(city[i][j] == 1) {
                    answer[i][j] = bfs(city, answer, i, j, r, c);
                }

            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(answer[i][j] + " ");

            }
            System.out.println();
        }


        return answer;
    }

    private static int bfs(int[][] city, int[][] answer, int i, int j, int r, int c) {

        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[501][501];

        int min = Integer.MAX_VALUE;

        queue.add(new Node(i, j, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (city[cur.i][cur.j] == 0) return Math.min(min, cur.dist);

            if (visited[cur.i][cur.j]) continue;

            visited[cur.i][cur.j] = true;

            for (int k = 0; k < 4; k++) {
                int ni = cur.i + di[k];
                int nj = cur.j + dj[k];

                if (ni < 0 || nj < 0 || ni >= r || nj >= c) continue;
                if (visited[ni][nj]) continue;
                if (answer[ni][nj] != 0) {
                    min = Math.min(min, 1 + answer[ni][nj]);
                    continue;
                }

                queue.add(new Node(ni, nj, cur.dist + 1));
            }
        }

        return min;
    }

    private static class Node {
        private int i, j;
        private int dist;

        public Node(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

}
