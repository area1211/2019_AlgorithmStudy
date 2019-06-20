package others;

// TODO: 2019-06-20
// Count number of ways to divide a number in 4 parts
public class CountNumber {

    static int dp[][][] = new int[5001][5001][5];

    static int countWaysUtil(int n, int parts, int nextPart) {
        if (parts == 0 && n == 0) return 1;
        if (n <= 0 || parts <= 0) return 0;

        if (dp[n][nextPart][parts] != -1)
            return dp[n][nextPart][parts];

        int ans = 0;

        for (int i = nextPart; i <= n; i++) {
            ans += countWaysUtil(n - i, parts - 1, i);
        }

        return (dp[n][nextPart][parts] = ans);
    }

    static int countWays(int n) {
        for (int i = 0; i < 5001; i++) {
            for (int j = 0; j < 5001; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = -1;
                }
            }

        }

        return countWaysUtil(n, 4, 1);
    }

//    static int countWays(int n) {
//        int counter = 0;
//        for (int i = 1; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                for (int k = j; k < n; k++) {
//                    for (int l = k; l < n; l++) {
//                        if (i + j + k + l == n)
//                            counter++;
//                    }
//                }
//            }
//        }
//
//        return counter;
//    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(countWays(8));
    }
}
