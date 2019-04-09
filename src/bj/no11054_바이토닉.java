package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2019-04-09
// 가장 긴 바이토닉 부분 수열
public class no11054_바이토닉 {

    static int[] arr = new int[1000];
    static int[][] dp = new int[2][1000];
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 0이 증가, 1이 감소

        for (int i = 0; i < N; i++) {
            dp[0][i] = 1;
            dp[1][i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[0][i] = Math.max(dp[0][j] + 1, dp[0][i]); // 증가 -> 증가
                    dp[1][i] = Math.max(dp[0][j] + 1, dp[1][i]); // 증가 -> 감소
                } else if (arr[i] < arr[j]) {
                    dp[1][i] = Math.max(dp[1][j] + 1, dp[1][i]); // 감소 -> 감소
                }
            }
        }


        for (int i = 0; i < N; i++) {
//            System.out.println(arr[i] + ":" + dp[0][i] + " , " + dp[1][i]);
            max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
        }

        System.out.println(max);

    }
}
