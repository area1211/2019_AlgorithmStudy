package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// TODO: 2019-04-16
public class no1963_소수경로 {
    static boolean[] isNotPrimeNumber = new boolean[10000];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 2; i < 10000; i++) {
            if (isNotPrimeNumber[i]) continue;

            for (int j = 2; i * j < 10000; j++) {
                isNotPrimeNumber[i * j] = true;
            }
        }

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] a = parseString(st.nextToken());
            int[] b = parseString(st.nextToken());

            System.out.println(BFS(a, b));
        }
    }

    static int[] parseString(String str) {
        int[] a = new int[4];
        for (int j = 0; j < 4; j++) {
            a[j] = str.charAt(j) - 48;
        }
        return a;
    }


    static int BFS(int[] a, int[] b) {
        int min = Integer.MAX_VALUE;
        LinkedList<Pair> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[10][10][10][10];

        visited[a[0]][a[1]][a[2]][a[3]] = true;
        queue.add(new Pair(a, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            if (Arrays.equals(p.a, b)) {
                min = Math.min(min, p.cnt);
            }

            for (int i = 0; i < 4; i++) {

                for (int j = 0; j <= 9; j++) {
                    int[] tempA = Arrays.copyOf(p.a, p.a.length);
                    tempA[i] = j;

                    int converted = tempA[0] * 1000 + tempA[1] * 100 + tempA[2] * 10 + tempA[3];
                    if (converted >= 1000 && !isNotPrimeNumber[converted] && !visited[tempA[0]][tempA[1]][tempA[2]][tempA[3]]) {
                        visited[tempA[0]][tempA[1]][tempA[2]][tempA[3]] = true;
                        queue.add(new Pair(tempA, p.cnt + 1));
                    }
                }

            }

        }

        return min;
    }

    static class Pair {
        int[] a;
        int cnt;

        public Pair(int[] a, int cnt) {
            this.a = a;
            this.cnt = cnt;
        }
    }
}
