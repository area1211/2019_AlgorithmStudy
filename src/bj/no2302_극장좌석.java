package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// TODO: 2019-04-26
public class no2302_극장좌석 {

    static int[] part = new int[41];
    static int[] dp = new int[41];
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int head = 1;
        int tail;
        for (int i = 0; i < M; i++) {
            tail = Integer.parseInt(br.readLine());

            part[i] = tail - head;
            MAX = Math.max(MAX, part[i]);
            head = tail + 1;
        }
        part[M] = N + 1 - head;
        MAX = Math.max(MAX, part[M]);

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= MAX; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int answer = 1;
        for (int i = 0; i <= M; i++) {
            answer *= dp[part[i]];
        }

        System.out.println(answer);
    }
}
