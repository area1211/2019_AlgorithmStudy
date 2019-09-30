package others;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p1 {

//    static int[][] cntArr = {
//            {0, 0, 0, 0, 0, 0, 0},
//            {0, 0, 1, 1, 1, 1, 2},
//            {0, 1, 0, 1, 2, 1, 1},
//            {0, 1, 1, 0, 1, 2, 1},
//            {0, 1, 2, 1, 0, 1, 1},
//            {0, 1, 1, 2, 1, 0, 1},
//            {0, 2, 1, 1, 1, 1, 0}
//    };

    static int[][] cntArr = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 1, 2},
            {0, 1, 0, 1, 1, 2, 1},
            {0, 1, 1, 0, 2, 1, 1},
            {0, 1, 1, 2, 0, 1, 1},
            {0, 1, 2, 1, 1, 0, 1},
            {0, 2, 1, 1, 1, 1, 0}
    };

//    static int[][] cntArr = {
//            {0, 0, 0, 0, 0, 0, 0},
//            {0, 0, 1, 1, 1, 1, 2},
//            {0, 1, 0, 2, 1, 1, 1},
//            {0, 1, 2, 0, 1, 1, 1},
//            {0, 1, 1, 1, 0, 2, 1},
//            {0, 1, 1, 1, 2, 0, 1},
//            {0, 2, 1, 1, 1, 1, 0}
//    };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(solution(new int[]{1, 2, 3}));
        System.out.println(solution(new int[]{1, 1, 6}));
        System.out.println(solution(new int[]{1, 6, 2, 3}));
        System.out.println(solution(new int[]{1, 6}));
        System.out.println(solution(new int[]{2, 4, 4}));
    }

    public static int solution(int[] A) {
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= 6; i++) {
            int cnt = 0;
            for (int j = 0; j < A.length; j++) {
                cnt += cntArr[A[j]][i];
            }
            min = Math.min(min, cnt);
        }

        return min;
    }
}
