package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// TODO: 2019-04-16
public class no2572_회전초밥중 {

    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] susi = new int[N];
        for (int i = 0; i < N; i++) {
            susi[i] = Integer.parseInt(br.readLine());
        }

        int[] visited = new int[d + 1];
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (visited[susi[i]]++ == 0){
                cnt++;
            }
        }

        // 쿠폰으로 준 초밥을 먹는다.
        if (visited[c]++ == 0){
            cnt++;
        }
        max = Math.max(max, cnt);

        for (int i = k; i < N + k; i++) {
            // 제일 앞에 먹은 초밥을 빼준다.
            if (--visited[susi[(N + i - k) % N]] == 0)
                cnt--;

            // 이제 먹을 초밥을 넣어준다.
            if (visited[susi[i % N]]++ == 0){
                cnt++;
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
