package others;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(solutionTest(new int[]{5, -2, 3, 8, 6}));
        System.out.println(solutionTest(new int[]{-5, -5, -5, -42, 6, 12}));
        System.out.println(solutionTest(new int[]{-5, -42, 7, -5, -5, 6, 12}));
    }

    public static int solution(int[] T) {
        // write your code in Java SE 8
        int answer = 0;
        for (int i = 0; i < T.length - 1 ; i++) {

            int winterMax = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                winterMax = Math.max(winterMax, T[j]);
            }

            int summerMin = Integer.MAX_VALUE;
            for (int j = i + 1; j < T.length; j++) {
                summerMin = Math.min(summerMin, T[j]);
            }

            if (winterMax < summerMin) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }


    public static int solutionTest(int[] T) {
        // write your code in Java SE 8
        int winterMax = T[0]; // 겨울 최고 온도
        int yearMax = T[0]; // 연간 최고 온도
        int position = 1;

        int n = T.length;
        for (int i = 1; i < n; i++) {

            if (T[i] < winterMax) {
                // 겨울 최고 온도 보다 낮은 온도가 발견 되면 겨울로 생각한다.
                position = i + 1;
                // 겨울 최고 온도를 갱신한다.
                winterMax = yearMax;
            } else if (T[i] > yearMax) {
                // 연간 최고 온도를 갱신한다.
                yearMax = T[i];
            }

        }

        return position;
    }

    public static int solutionTest2(int[] T) {
        // write your code in Java SE 8
        int winterMax = T[0];
        int max = T[0];
        int position = 1;

        int n = T.length;

        for (int i = 1; i < n; i++) {

            if (T[i] < winterMax) {
                // 겨울 최고 온도 보다 낮은 온도가 발견 되면 겨울로 생각한다.
                position = i + 1;
                winterMax = max;
            } else if (T[i] > max) {
                //
                max = T[i];
            }
        }

        return position;
    }
}
