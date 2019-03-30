package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// TODO: 2019-03-30
// [DFS]no1389 케빈베이컨 성공
public class no1389_케빈베이컨 {

    static class Pair {
        int v;
        int distance;

        Pair(int v, int distance) {
            this.v = v;
            this.distance = distance;
        }
    }

    static class Graph {
        int V;
        LinkedList<Integer>[] adj;

        Graph (int V) {
            this.V = V;
            adj = new LinkedList[V + 1];
            for (int i = 0; i < V + 1; i++) {
                adj[i] = new LinkedList<>();

            }
        }

        void addEdge(int v, int w) {
            if (adj[v].contains(w)) return;

            adj[v].add(w);
            adj[w].add(v);

        }

        int BFS(int s, int target) {
            boolean[] visited = new boolean[V + 1];

            visited[s] = true;

            LinkedList<Pair> queue = new LinkedList<>();
            queue.add(new Pair(s, 0));

            while (queue.size() != 0) {
                Pair p = queue.poll();
                if (p.v == target) return p.distance;

                for (int m : adj[p.v]) {

                    if(!visited[m]) {
                        visited[m] = true;
                        queue.add(new Pair(m, p.distance + 1));
                    }

                }

            }

            return 0;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Graph g = new Graph(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            g.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Pair max = new Pair(0, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {

            int kevinBacon = 0;

            for (int j = 1; j <= N; j++) {
                kevinBacon += g.BFS(i, j);
            }

            if (max.distance > kevinBacon) {
                max = new Pair(i, kevinBacon);
            }

        }

        System.out.println(max.v);

    }
}
