package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// TODO: 2019-03-22
public class no6603_로또 {

    static int[] set = new int[14];
    static int N = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(N != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++) {
                set[i] = Integer.parseInt(st.nextToken());
            }

            LinkedList<Integer> list = new LinkedList<>();
            DFS(1, list);

            System.out.println();
        }
    }

    static void DFS(int i, LinkedList<Integer> list) {
        if(list.size() == 6) {
            for (int n :
                    list) {
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for (int j = i; j <= N; j++) {
            list.add(set[j]);
            DFS(j + 1, list);
            list.removeLast();
        }

    }
}
