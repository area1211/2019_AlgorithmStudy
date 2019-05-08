package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// TODO: 2019-05-06
// 다익스트라
public class no1238_파티 {

    static final int MAX = 987654321;
    static int N, M, X;

    static int[][] dist = new int[1001][1001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = (i == j) ? 0 : MAX;
            }
        }

//        Graph g = new Graph(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
//            g.addEdge(st.nextToken(), st.nextToken(), st.nextToken());

            dist[a][b] = cost;
        }


        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {

                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }

                }
            }
        }


        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
//            max = Math.max(max, g.dijkstra(i, X) + g.dijkstra(X, i));
            max = Math.max(max, dist[i][X] + dist[X][i]);
        }

        System.out.println(max);
    }


    static class Graph {
        int V;
        LinkedList<Node>[] adjs;
        int[] dist;
        boolean[] visited;

        public Graph(int v) {
            V = v;
            adjs = new LinkedList[V + 1];
            for (int i = 0; i < V + 1; i++) {
                adjs[i] = new LinkedList<>();
            }
            dist = new int[V + 1];
            visited = new boolean[V + 1];
        }

        void addEdge(int v, int w, int d) {
            adjs[v].add(new Node(w, d));
        }

        void addEdge(String v, String w, String d) {
            addEdge(Integer.parseInt(v), Integer.parseInt(w), Integer.parseInt(d));
        }

        int dijkstra(int source, int dest) {
            PriorityQueue<Node> queue = new PriorityQueue<>();

            Arrays.fill(dist, MAX);
            Arrays.fill(visited, false); // 방문 배열 초기화

            dist[source] = 0;
            queue.add(new Node(source, dist[source]));

            while (!queue.isEmpty()) {
                Node curNode = queue.poll();
                if (visited[curNode.index]) continue;
                if (dist[curNode.index] < curNode.distance) continue;

                visited[curNode.index] = true;

                for (Node adj :
                        adjs[curNode.index]) {

                    if (!visited[adj.index] && dist[adj.index] > dist[curNode.index] + adj.distance) {
                        dist[adj.index] = dist[curNode.index] + adj.distance;

                        queue.add(new Node(adj.index, dist[adj.index]));
                    }

                }
            }

            return dist[dest];
        }
    }

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }
}
