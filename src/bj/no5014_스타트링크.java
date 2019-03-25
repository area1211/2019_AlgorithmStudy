package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no5014_스타트링크 {

    static class Pair {
        int position;
        int cnt;

        Pair(int position, int cnt) {
            this.position = position;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());


        boolean[] visited = new boolean[F + 1];
        LinkedList<Pair> queue = new LinkedList<>();

        visited[S] = true;
        queue.addLast(new Pair(S, 0));

        while (queue.size() != 0) {
            Pair cur = queue.poll();

            if (cur.position == G) {
                System.out.println(cur.cnt);
                return;
            }

            int up = cur.position + U;
            int down = cur.position - D;

            if (up <= F && !visited[up]) {
                visited[up] = true;
                queue.add(new Pair(up, cur.cnt + 1));
            }

            if (down >= 1 && !visited[down]) {
                visited[down] = true;
                queue.add(new Pair(down, cur.cnt + 1));
            }

        }

        System.out.println("use the stairs");

    }
}
