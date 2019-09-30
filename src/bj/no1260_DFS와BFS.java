package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class no1260_DFS와BFS {
    static int N, M, startV;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = sc.nextInt();
        M = sc.nextInt();
        startV = sc.nextInt();

        GraphB g = new GraphB(N);

        for (int i = 0; i < M; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            g.addEdge(a, b);
            g.addEdge(b, a);
        }


        g.DFS(startV);
        System.out.println();
        g.BFS(startV);

    }
}

class GraphB {
    private int V;
    private LinkedList<Integer> adj[];
//    private PriorityQueue<Integer> adj[];
    boolean dfsVisited[];

    GraphB(int v) {
        V = v;
        adj = new LinkedList[v + 1];
        for (int i = 0; i < v + 1; i++) {
            adj[i] = new LinkedList<>();
        }
        dfsVisited = new boolean[V + 1];
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        Collections.sort(adj[v]);
    }

    void DFS(int s) {
        dfsVisited[s] = true;
        System.out.print(s + " ");


        Iterator<Integer> i = adj[s].listIterator();
        while (i.hasNext()) {
            int n = i.next();
//            System.out.print(n + " ");

            if(!dfsVisited[n]) {

                dfsVisited[n] = true;
                DFS(n);
            }
        }

    }

    void BFS(int s) {
        boolean visited[] = new boolean[V + 1];
        LinkedList<Integer> queue = new LinkedList<>();
//        PriorityQueue<Vertex> datastructure.queue = new PriorityQueue<>();
//        PriorityQueue<Integer> datastructure.queue = new PriorityQueue<>();

//        System.out.print(s + " ");
        visited[s] = true;
//        datastructure.queue.add(new Vertex(s));
        queue.add(s);
//        System.out.println(datastructure.queue.toString());

        Vertex vertex;
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

//            Iterator<Integer> i = adj[s].iterator();
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();

                if(!visited[n]) {

                    visited[n] = true;
//                    datastructure.queue.add(new Vertex(n));
                    queue.add(n);
                }
            }
        }
    }
}

class Vertex implements Comparable<Vertex> {
    int num;

    Vertex(int num) {
        this.num = num;
    }


    @Override
    public int compareTo(Vertex target) {
        return this.num > target.num ? 1 : -1;
    }
}