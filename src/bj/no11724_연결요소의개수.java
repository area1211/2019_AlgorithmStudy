package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class no11724_연결요소의개수 {
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        M = Integer.parseInt(tokens[1]);

        GraphC g = new GraphC(N);

        for (int i = 0; i < M; i++) {
            tokens = br.readLine().split(" ");
            g.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if(!g.visited[i]) {
                g.BFS(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

class GraphC {
    private int V;
    private LinkedList<Integer>[] adj;
    boolean[] visited;

    GraphC(int v) {
        V = v;
        adj = new LinkedList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            adj[i] = new LinkedList<>();
        }
        visited = new boolean[V + 1];
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void BFS(int s) {
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0) {
            s = queue.poll();

            queue.addAll(adj[s].stream().filter(n -> {
                if(!visited[n]) {
                    visited[n] = true;
                    return true;
                }
                return false;
            }).collect(Collectors.toList()));

//            Iterator<Integer> iter = adj[s].listIterator();
//            while(iter.hasNext()) {
//                int n = iter.next();
//
//                if(!visited[n]) {
//                    visited[n] = true;
//                    queue.add(n);
//                }
//            }
        }

    }
}
