package bj.rethink;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// TODO: 2019-03-29
// https://www.acmicpc.net/problem/9251
// [DP]no9251 LCS 성공 : 두 개의 문자열을 동시에 비교해야하니까 2차원 배열로 풀어내는 아이디어가 신기했따.
public class no9251_LCS {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str2.length() + 1][str1.length() + 1];

        for (int i = 1; i <= str2.length(); i++) {
            for (int j = 1; j <= str1.length(); j++) {

                if (str1.charAt(j - 1) == str2.charAt(i - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

            }
        }

        System.out.println(dp[str2.length()][str1.length()]);

    }
}
