package bj;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class no11403_경로찾기 {

    static int V = 0;
    static int[][] result;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        Graph g = new Graph(V);
        result = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(sc.nextInt() == 1)
                    g.addEdge(i, j);
            }
        }

        for (int i = 0; i < V; i++) {
            g.BFS(i, result);
        }


        for(int[] row: result) {
            for(int value: row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }


    }

}

class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s, int[][] result) {
        int initialV = s;
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

//        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
//            System.out.print(s + " ");
            result[initialV][s] += 1;

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();

                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
//        System.out.println();

        result[initialV][initialV] -= 1;

    }
}