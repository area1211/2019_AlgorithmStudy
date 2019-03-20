package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class no1003_피보나치함수 {
//    static int[] cnt = new int[2];
    static int[][] cnt = new int[41][2];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        cnt[0][0] = 1; cnt[0][1] = 0;
        cnt[1][0] = 0; cnt[1][1] = 1;

        for (int i = 0; i < T; i++) {

            int n = Integer.parseInt(br.readLine());

            for (int j = 2; j <= n; j++) {
                cnt[j][0] = cnt[j-2][0] + cnt[j-1][0];
                cnt[j][1] = cnt[j-2][1] + cnt[j-1][1];
            }

            System.out.println(cnt[n][0] + " " + cnt[n][1]);
        }
    }

//    static int fibonacci(int n) {
//        if (n == 0) {
//            cnt[0]++;
//            return 0;
//        } else if (n == 1) {
//            cnt[1]++;
//            return 1;
//        } else {
//            return fibonacci(n-1) + fibonacci(n - 2);
//        }
//    }
}
