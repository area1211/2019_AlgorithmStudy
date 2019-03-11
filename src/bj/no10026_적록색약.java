package bj;

import java.util.Scanner;

// 실패...
public class no10026_적록색약 {

    static int dx[]={1,0,-1,0};
    static int dy[]={0,1,0,-1};
    static int N;
    static boolean visited[][] = new boolean[100][100];
    static boolean visited2[][] = new boolean[100][100];
    static char image[][] = new char[100][100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                image[i][j] = str.charAt(j);
            }
        }

        int resultA = 0; // 정상인
        int resultB = 0; // 색약인

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    DFS(i, j);
                    resultA++;
                }
            }
        }
        System.out.print(resultA + " ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited2[i][j]) {
                    DFS2(i, j);
                    resultB++;
                }
            }
        }
        System.out.print(resultB);
    }

    static void DFS(int i, int j) {

        for (int k = 0; k < 4; k++) {

            int ni = i + dy[k];
            int nj = j + dx[k];

            if(ni < 0 || nj < 0 || ni >= N || nj >= N || visited[ni][nj]) continue;
            if(image[i][j] != image[ni][nj]) continue;
            visited[ni][nj] = true;
            DFS(ni, nj);
        }
    }

    static void DFS2(int i, int j) {

        for (int k = 0; k < 4; k++) {

            int ni = i + dy[k];
            int nj = j + dx[k];

            if(ni < 0 || nj < 0 || ni >= N || nj >= N || visited2[ni][nj]) continue;
            if(image[i][j] != image[ni][nj]) {
                if((image[i][j] == 'R' || image[i][j] == 'G')
                    && (image[ni][nj] == 'R' || image[ni][nj] == 'G') ) ;
                else
                    continue;
            }

            visited2[ni][nj] = true;
            DFS2(ni, nj);
        }
    }

}
