package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// TODO: 2019-03-20
public class no9461_파도반수열 {

    static long[] P = new long[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int T = Integer.parseInt(br.readLine());

        padovan();

//        for (int i = 0; i < T; i++) {
//            int n = Integer.parseInt(br.readLine());
//            System.out.println(P[n]);
//        }

        for (int i = 6; i <= 100; i++) {
            System.out.println("P[" + i + "] = " + P[i] + " = " + P[i-1] + " + " + P[i-5]);
        }

    }

    static void padovan() {
        P[1] = P[2] = P[3] = 1;
        P[4] = P[5] = 2;
        for (int i = 6; i <= 100; i++) {
            P[i] = P[i - 1] + P[i - 5];
        }
    }
}
