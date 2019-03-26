package bj.fail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no2293_동전1 {

    static int n, k, cnt;
    static int[] coin = new int[100];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        LinkedList<Integer> list = new LinkedList<>();

        DFS(0, list);

        System.out.println(cnt);
    }

    static void DFS(int sum, LinkedList<Integer> list) {
        if(sum == k) {
            for (int n :
                    list) {
                System.out.print(n + " ");
            }
            System.out.println();
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {

            if (sum + coin[i] <= k) {
                list.add(coin[i]);
                DFS(sum + coin[i], list);
                list.removeLast();
            }

        }
    }
}
