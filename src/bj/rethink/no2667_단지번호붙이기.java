package bj.rethink;

import java.util.*;

public class no2667_단지번호붙이기 {
    static int dx[]={1,0,-1,0};
    static int dy[]={0,1,0,-1};
    static int N;
    static boolean visited[][] = new boolean[100][100];
    static int map[][] = new int[100][100];
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            String arr[] = str.split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    cnt = 0;
                    visited[i][j] = true;
                    DFS(i, j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int result:
             list) {
            System.out.println(result);
        }

    }
    
    static void DFS(int i, int j) {

        cnt++;
        for (int k = 0; k < 4; k++) {
            int ni = i + dy[k];
            int nj = j + dx[k];

            if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
            if(map[ni][nj] == 0 || visited[ni][nj]) continue;
            visited[ni][nj] = true;
            DFS(ni, nj);
        }
    }
}
