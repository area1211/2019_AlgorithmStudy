package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: 2019-05-05
public class no1495_기타리스트 {
    static final int MIN = -987654321;

    static int N, S, M;
    static int[] song = new int[101];
    static int[][] dp = new int[101][1001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            song[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], MIN);
        }


        System.out.println(dp(S, 1));

    }

    static int dp(int vol, int order) {
        if (vol < 0 || vol > M) { // 0보다 작거나 M보다 큰 값으로는 볼륨을 바꿀 수 없다.
            return -1;
        }
        if (order > N) {
            return vol; // 끝까지 연주했으면
        }
        if (dp[order][vol] != MIN) {
            return dp[order][vol]; // 불가능(-1)하거나 이미 값을 구한 경우
        }


        dp[order][vol] = Math.max(dp(vol + song[order], order + 1), dp(vol - song[order], order + 1));
        dp[order][vol] = dp[order][vol] >= 0 ? dp[order][vol] : -1;
        return dp[order][vol];
    }
}
