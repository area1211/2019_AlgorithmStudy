package bj.rethink;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// TODO: 2019-04-20
// no9251 LCS  두 번째 도전
public class no9251_2_LCS {

    static int[][] dp = new int[1001][1001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        for (int i = 0; i < str2.length(); i++) {

            for (int j = 0; j < str1.length(); j++) {


                if (str2.charAt(i) == str1.charAt(j)) {


                    dp[i+1][j+1] = dp[i][j] + 1;


                } else {

                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);

                }


            }

        }


        System.out.println(dp[str2.length()][str1.length()]);
    }
}
