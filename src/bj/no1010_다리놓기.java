package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no1010_다리놓기 {

    static int N, M, cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        while(T-- != 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

//            long res = 1;
//            BigInteger bi = BigInteger.ONE;
//            M = N - M > M ? M : N - M;
//
//            for (int i = N; i >= N - M + 1; i--) {
//                res *= i;
//                bi = bi.multiply(BigInteger.valueOf(i));
//            }
//            for (int i = 1; i <= M; i++) {
//                res /= i;
//                bi = bi.divide(BigInteger.valueOf(i));
//            }
//            System.out.println(res);
//            System.out.println(bi);

            LinkedList<Integer> list = new LinkedList<>();
            DFS(1, list);

            System.out.println(cnt);
            cnt = 0;
        }



    }

    static void DFS(int i, LinkedList<Integer> list) {
        if (list.size() == M) {
            cnt++;
            return;
        }

        for (int j = i; j <= N; j++) {
            list.add(j);
            DFS(j + 1, list);
            list.removeLast();
        }

    }
}
