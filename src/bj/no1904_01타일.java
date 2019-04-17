package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// TODO: 2019-04-17
// C(N,K) mod p = (C(1,0) mod 13 ) * (C(1,1) mod 13) = 1
public class no1904_01타일 {
    static final int DIVISOR = 15746;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());


        int[] arr = {1, 2, 0};


        for (int i = 0; i < N - 2; i++) {
            arr[(2 + i) % 3] = (arr[(3 + i) % 3] % DIVISOR + arr[(4 + i) % 3] % DIVISOR) % DIVISOR;
        }

        System.out.println(arr[(N + 2) % 3]);


    }


    static long fac(int n) {
        int result = 1;
        // (a x b) mod n = (a mod n x b mod n)mod n
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result % DIVISOR;
    }

    static int modFact(int n) {
        if (n >= DIVISOR)
            return 0;

        int result = 1;
        for (int i = 1; i <= n; i++)
            result = (result * i) % DIVISOR;

        return result;
    }


    static long modInv(long a, int M) {
        if (M == 1)
            return a;
        if (M == 0)
            return 1;

        long tmp = modInv(a, M / 2);
        if (M % 2 == 1)
            return (((tmp * tmp) % DIVISOR) * a) % DIVISOR;
        else
            return (tmp * tmp) % DIVISOR;
    }


}
