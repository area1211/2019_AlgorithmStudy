package bj.rethink;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// TODO: 2019-03-29
// https://www.acmicpc.net/problem/9251
// [DP]no9251 LCS 성공 : 두 개의 문자열을 동시에 비교해야하니까 2차원 배열로 풀어내는 아이디어가 신기했따.
public class no9251_LCS {

    static String str1, str2;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();
        dp = new int[str2.length() + 1][str1.length() + 1];

        // 초기화. 0행 0열은 0으로, 아직 구해지지 않은 dp는 -1로
        for (int i = 1; i < str2.length() + 1; i++) {
            for (int j = 1; j < str1.length() + 1; j++) {
                dp[i][j] = -1;
            }
        }


        // top-down
        System.out.println(dp(str2.length(), str1.length()));

        // bottom-up

//
//        for (int i = 1; i <= str2.length(); i++) {
//            for (int j = 1; j <= str1.length(); j++) {
//
//                if (str1.charAt(j - 1) == str2.charAt(i - 1))
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                else
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//
//            }
//        }
//
//        System.out.println(dp[str2.length()][str1.length()]);

    }

    static int dp(int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        else if (dp[i][j] != -1)
            return dp[i][j];

        if (str1.charAt(j - 1) == str2.charAt(i - 1))
            dp[i][j] = dp(i - 1, j - 1) + 1;
        else
            dp[i][j] = Math.max(dp(i-1,j), dp(i, j-1));

        return dp[i][j];
    }
}
