package bj;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class no2583_영역구하기 {

    static int dx[]={1,0,-1,0};
    static int dy[]={0,1,0,-1};
    static int M, N, K;
    static boolean visited[][] = new boolean[100][100];
    static boolean map[][] = new boolean[100][100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> resultArr = new LinkedList<>();
        int x1, x2, y1, y2;
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

//        visited = new boolean[M][N];
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(visited[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < K; i++) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    visited[j][k] = true;
                }
            }

        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    int result = DFS(j, i);
                    resultArr.add(result);
                }
            }
        }

        Collections.sort(resultArr);
        for (int size :
                resultArr) {
            System.out.print(size + " ");
        }
    }

    public static int DFS(int x, int y) {
        int size = 1;
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[ny][nx]) continue;
            size += DFS(nx, ny);
        }
        return size;
    }

    public static void BFS(int x, int y) {
        if(visited[y][x] == true) return;
        LinkedList<Pair> queue = new LinkedList<>();
        int size = 0;

        visited[y][x] = true;
        size++;
        queue.add(new Pair(x, y));

        Pair location;
        while (queue.size() != 0) {
            location = queue.poll();

            Pair newLocation;

        }
    }

    public static boolean locationValidCheck(Pair<Integer, Integer> pair) {
        if (pair.getX() < 0 || pair.getX() >= N) return false;
        if (pair.getY() < 0 || pair.getY() >= M) return false;
        return true;
    }
}

class Pair<K,V> {
    private K key;
    private V value;

    public Pair(K key, V value)
    {
        this.key=key;
        this.value=value;
    }

    public void setKey(K key) {this.key=key;}
    public void setValue(V value) {this.value=value;}

    public K getX(){return key;}
    public V getY(){return value;}
}