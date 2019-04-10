package bj.rethink;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class no9466_텀프로젝트 {


    static boolean[] visited;
    static boolean[] isFinished;
    static int[] student;

    static int n, cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            student = new int[n + 1];
            visited = new boolean[n + 1];
            isFinished = new boolean[n + 1];
            cnt = 0;

//            Graph g = new Graph(n);
            for (int j = 1; j <= n; j++) {
                student[j] = Integer.parseInt(st.nextToken());

//                g.addEdge(j, student[j]);
            }

            int answer = n;
            for (int j = 1; j <= n; j++) {
                if(visited[j]) continue;


                DFS(j);

//                g.init();
//                g.DFS(j, j, new LinkedList<>());
//                if (g.studentSize > 0) {
//                    answer -= g.studentSize;
//                }
            }

            System.out.println(answer - cnt);
        }
    }

    static void DFS(int s) {
        visited[s] = true;

        int target = student[s];
        if (!visited[target]) {
            DFS(target);
        } else {
            // 이미 방문한 곳을 또 방문했다는 것은 Cycle을 이룬다는 것이다.
            if (!isFinished[target]) {

                for (int i = target; s != i ; i = student[i]) {
                    cnt++;
                }
                cnt++;

            }
        }

        isFinished[s] = true;
    }

    static class Graph {
        int V;
        LinkedList<Integer>[] adj;

        int[] teamNum;
        int teamSize;
        int studentSize;

        Graph(int v) {
            this.V = v;
            adj = new LinkedList[v + 1];
            for (int i = 0; i < v + 1; i++) {
                adj[i] = new LinkedList<>();
            }

            teamNum = new int[v + 1];
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void init() {
            studentSize = 0;
        }

        void DFS(int start, int current, List<Integer> list) {
            if (teamNum[current] != 0)
                return;
            if (list.contains(current)) {

                for (int i = 0; i < list.indexOf(current); i++) {
                    teamNum[list.get(i)] = -1;
                }

                teamSize++;
                for (int i = list.indexOf(current); i < list.size(); i++) {
                    teamNum[list.get(i)] = teamSize;
                }

                studentSize = list.size() - list.indexOf(current);
                return;
            }

            list.add(current);

            DFS(start, adj[current].get(0), list);
        }
    }
}
