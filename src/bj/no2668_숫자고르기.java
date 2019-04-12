package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// TODO: 2019-04-13
public class no2668_숫자고르기 {

    static boolean[] visited = new boolean[101];
    static boolean[] isFinished = new boolean[101];
    static int[] arr = new int[101];
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        for (int i = 1; i <= N; i++) {

            if (!visited[i])
                DFS(i);

        }

        System.out.println(set.size());
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int item : list) {
            System.out.println(item);
        }

    }

    static void DFS(int s) {
        visited[s] = true;

        int target = arr[s];
        if (!visited[target]) {
            DFS(target);
        } else {
            // 이미 방문한 곳을 또 방문했다는 것은 Cycle을 이룬다는 것이다.
            if (!isFinished[target]) {

                for (int i = target; s != i ; i = arr[i]) {
                    set.add(i);
                }
                set.add(s);

            }
        }

        isFinished[s] = true;
    }
}
