package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

// TODO: 2019-04-17
public class no1613_역사 {

    static final int MAX = 987654321;
    static int[][] map = new int[401][401];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


//        Graph g = new Graph(n);

        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                map[i][j] = (i == j) ? 0 : MAX;
//            }
            Arrays.fill(map[i], MAX);
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
//            g.addEdge(a, b);

            map[a][b] = -1;
            map[b][a] = 1;
        }

        for (int m = 1; m <= n; m++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {

//                    if (map[i][j] > map[i][m] + map[m][j]) {
//                        map[i][j] = map[i][m] + map[m][j];
//                    }

                    if (map[i][m] == -1 && map[m][j] == -1) {
                        map[i][j] = -1;
                        map[j][i] = 1;
                    }

                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == MAX) {
                    System.out.print(0);
                } else
                    System.out.print(map[i][j]);
            }
            System.out.println();
        }

//        for (int i = 1; i <= n; i++) {
//            g.init();
//            g.DFS(i, new SingleLinkedList<>());
//        }

//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                if(g.map[i][j])
//                    System.out.print("1");
//                else
//                    System.out.print("0");
//            }
//            System.out.println();
//        }


        StringBuilder sb = new StringBuilder();
        int s = Integer.parseInt(br.readLine());
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

//            if (map[a][b] != MAX) {
//                sb.append("-1\n");
//            } else if (map[b][a] != MAX) {
//                sb.append("1\n");
//            } else {
//                sb.append("0\n");
//            }

            if (map[a][b] != MAX) {
                sb.append(map[a][b] + "\n");
            } else {
                sb.append("0\n");
            }

//            if (g.map[a][b]) {
//                sb.append("-1\n");
//            } else if (g.map[b][a]) {
//                sb.append("1\n");
//            } else {
//                sb.append("0\n");
//            }

//            g.init();
//            g.target = b;
//            g.DFS(a);
//            if(g.result) {
//                sb.append("-1\n");
//            } else {
//                g.init();
//                g.target = a;
//                g.DFS(b);
//                if (g.result) {
//                    sb.append("1\n");
//                } else {
//                    sb.append("0\n");
//                }
//            }

        }

        System.out.println(sb.toString());

    }

    static class Graph {
        int V;
        LinkedList<Integer>[] adj;
        boolean[] visited;
        //        int target;
        boolean result;
        boolean[][] map = new boolean[401][401];

        public Graph(int v) {
            V = v;
            adj = new LinkedList[V + 1];
            for (int i = 0; i < V + 1; i++) {
                adj[i] = new LinkedList<>();
            }
            visited = new boolean[V + 1];
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void init() {
            result = false;
            for (int i = 0; i < V + 1; i++) {
                visited[i] = false;
            }
        }

        void DFS(int s, LinkedList<Integer> list) {

            list.forEach(start -> {
                map[start][s] = true;
            });

            visited[s] = true;
            list.add(s);

            for (int n :
                    adj[s]) {

//                if(n == target) {
//                    result = true;
//                    return;
//                }

                if (!visited[n] && !map[s][n]) {
                    DFS(n, list);
                    list.remove(Integer.valueOf(n));
                }

            }

        }
    }
}
