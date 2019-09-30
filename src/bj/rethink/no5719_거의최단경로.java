package bj.rethink;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// TODO: 2019-05-01
// [다익스트라/BFS/그래프]no5719 최단경로 다시 풀어보자 : 다익스트라로 dist 배열을 구한 후, 입력받은 간선 정보를 바탕으로 최단 경로를 BFS로 구할 수 있다.
public class no5719_거의최단경로 {
    static final int MAX = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 정점의 수, 간선의 수
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 종료 조건
            if (N == 0 && M == 0) break;

            st = new StringTokenizer(br.readLine());

            // 시작점, 도착점
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            Graph g = new Graph(N);

            for (int i = 0; i < M; i++) {
                // 간선 입력
                st = new StringTokenizer(br.readLine());
                g.addEdge(st.nextToken(), st.nextToken(), st.nextToken());
            }


            dijkstra(g, S);
            dfs(g, S, D);
            dijkstra(g, S);

            if (g.dist[D] == MAX)
                sb.append(-1 + "\n");
            else
                sb.append(g.dist[D] + "\n");

        }

        System.out.println(sb.toString());
    }

    static void dfs(Graph g, int source, int dest) {
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(dest);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == source) continue;

            for (Node toNode :
                    g.revs[cur]) {

                if (g.dist[cur] == g.dist[toNode.n] + toNode.d) {
                    g.isMinPath[toNode.n][cur] = true;
                    queue.add(toNode.n);
                }
            }
        }
    }


    static void dijkstra(Graph g, int source) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        g.init(source);
        // 방문배열 초기화
        for (int i = 0; i < g.V; i++) {
            g.visited[i] = false;
        }

        queue.add(new Node(source, g.dist[source]));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (g.visited[curNode.n]) continue;
            g.visited[curNode.n] = true;

            if (g.dist[curNode.n] < curNode.d) continue;

            for (Node adj :
                    g.adjs[curNode.n]) {

                if (!g.isMinPath[curNode.n][adj.n] && !g.visited[adj.n] && g.dist[adj.n] > g.dist[curNode.n] + adj.d) {
                    g.dist[adj.n] = g.dist[curNode.n] + adj.d;
                    g.prev[adj.n] = curNode.n;

                    queue.add(new Node(adj.n, g.dist[adj.n]));
                }
            }
        }
    }


    static class Graph {
        int V;
        LinkedList<Node>[] adjs;
        LinkedList<Node>[] revs;
        int[] prev, dist;
        boolean[] visited;
        boolean[][] isMinPath = new boolean[500][500];

        public Graph(int v) {
            V = v;
            adjs = new LinkedList[V];
            revs = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adjs[i] = new LinkedList<>();
                revs[i] = new LinkedList<>();
            }
            prev = new int[V];
            dist = new int[V];
            visited = new boolean[V];
        }

        void init(int source) {
            // Graph안에 있는 모든 노드들의 초기화
            for (int i = 0; i < V; i++) {
                dist[i] = MAX; // 소스와 V노드 사이에 알려지지 않은 거리 --얼마나 먼지 모르니까-- = 무한값 ( 모든 노드들을 초기화하는 값)
                prev[i] = -1; // V노드의  최적경로 추적 초기화
                //  Graph에 존재하고 방금 전 초기화된 V 노드를 Q(방문되지 않은 노드들의 집합)에 추가

            }
            dist[source] = 0;
        }

        void addEdge(int v, int w, int d) {
            adjs[v].add(new Node(w, d));
            revs[w].add(new Node(v, d));
        }

        void addEdge(String v, String w, String d) {
            addEdge(Integer.parseInt(v), Integer.parseInt(w), Integer.parseInt(d));
        }
    }

    static class Node implements Comparable<Node> {
        int n, d;

        public Node(int n, int d) {
            this.n = n;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.d, o.d);
        }
    }
}
