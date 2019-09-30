package bj;

import java.util.LinkedList;
import java.util.Scanner;

public class no7569_토마토 {
    static int dx[]={1,0,-1,0,0,0};
    static int dy[]={0,1,0,-1,0,0};
    static int dz[]={0,0,0,0,1,-1};

    static int M, N, H;
    static int box[][][] = new int[101][101][101];
    static boolean visited[][][] = new boolean[101][101][101];
    static LinkedList<Tomato> queue = new LinkedList<>();

    static int cnt = 0; //익지 않은 토마토의 개수
    static int day = 0;
    static boolean flag = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = sc.nextInt();
                    if(box[i][j][k] == 0) cnt++;
                    else if (box[i][j][k] == 1) {
                        queue.add(new Tomato(i, j, k, box[i][j][k]));
                    }
                }
            }
        }

//        System.out.println(cnt);
        if (cnt == 0 ) {
            System.out.println(0);
            return;
        }

        BFS();


//        System.out.println("안익은사과의개수:" + cnt);
//        System.out.println("날짜:"+ (day));
        if (cnt == 0 ) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }



    }

    static void print() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    System.out.print(box[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }


    static void BFS() {
        Tomato p;


//        PriorityQueue<Tomato> datastructure.queue = new PriorityQueue<>();
//        datastructure.queue.add(new Tomato(i, j, k, box[i][j][k]));

        while(!queue.isEmpty()) {

            p = queue.poll();

            for (int l = 0; l < 6; l++) {
                int nx = p.k + dx[l];
                int ny = p.j + dy[l];
                int nz = p.i + dz[l];

                if (nx < 0 || nx >= M) continue;
                if (ny < 0 || ny >= N) continue;
                if (nz < 0 || nz >= H) continue;
                if (box[nz][ny][nx] == -1 || box[nz][ny][nx] != 0) continue;

                if (box[nz][ny][nx] == 0) {
                    cnt--;
                    day = box[p.i][p.j][p.k];
                    box[nz][ny][nx] = box[p.i][p.j][p.k] + 1;
                }
//                print();
                queue.add(new Tomato(nz, ny, nx, box[nz][ny][nx]));
            }

        }
    }
}

class Tomato implements Comparable<Tomato>{
    int i, j, k;
    int priority;
    Tomato(int i, int j, int k, int priority) {
        this.i = i;
        this.j = j;
        this.k = k;
        this.priority = priority;
    }

    @Override
    public int compareTo(Tomato target) {
        return this.priority > target.priority ? 1 : -1;
    }
}
