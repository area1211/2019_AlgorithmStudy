package bj.rethink;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// TODO: 2019-04-10
// 항상 하던데로 static class Graph를 구현해서 풀려고 했는데 시간초과가 났다.
// 그냥 static 변수들과 static 메소드로만 풀었더니 시간초과가 안났다...
public class no1325_효율적인해킹 {

    static int N, M;
    static boolean[] visited;
    static ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[10001];
    static int[] ans = new int[10001];


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

//        Graph g = new Graph(N);
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

//            g.addEdge(b, a);
//            g.addEdge(a, b);
            adj[a].add(b);
        }


        int max = Integer.MIN_VALUE;
        List<Integer> answerList = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i);
//            g.init();
//            g.DFS2(i);
//            g.DFS(i);
//
//            g.dp[i] = g.cnt;
//
//            System.out.print(g.dp[i] + " ");



//            if (max < g.cnt) {
//                answerList.clear();
//                max = g.cnt;
//                answerList.add(i);
//            } else if (max == g.cnt) {
//                answerList.add(i);
//            }
        }

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, ans[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if(max == ans[i]) {
//                answerList.add(i);
                sb.append(i + " ");
            }
        }

//        System.out.println();

//        Collections.sort(answerList);
//        for (int answer :
//                answerList) {
//            System.out.print(answer + " ");
//        }

        System.out.println(sb.toString());

    }

    static void dfs(int s) {
        visited[s] = true;

        for (int next :
                adj[s]) {

            if (!visited[next]){
                ans[next]++;
                dfs(next);
            }

        }
    }


    static class Graph {
        int V;
        LinkedList<Integer>[] adj;
        boolean[] visited;
        int[] dp;
        int cnt;

        Graph(int v) {
            V = v;
            adj = new LinkedList[v + 1];
            for (int i = 0; i < v + 1; i++) {
                adj[i] = new LinkedList<>();
            }

            dp = new int[v + 1];
        }

        void init() {
            cnt = 0;
            visited = new boolean[V + 1];
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void DFS(int s) {
            visited[s] = true;

            for (int next :
                    adj[s]) {

                if (!visited[next]){
                    cnt++;
                    DFS(next);
                }

            }

        }

        void DFS2(int s) {
            visited[s] = true;

            for (int next :
                    adj[s]) {

                if (!visited[next]){
                    dp[next]++;
                    DFS2(next);
                }

            }
        }
    }
}


