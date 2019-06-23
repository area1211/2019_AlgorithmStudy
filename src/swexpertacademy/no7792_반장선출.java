package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

// TODO: 2019-06-23
public class no7792_반장선출 {

    public static void main(String args[]) throws Exception {
        int[] primArr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        int[] temp = new int[59];
        temp[0] = 103;
        for (int i = 0; i < primArr.length; i++) {
            temp[temp.length - i - 1] = primArr[i];
        }
        primArr = temp;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());

            int max = 0;
            String leader = "";

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                char[] chars = str.toCharArray();

                BigInteger bigInteger = BigInteger.ONE;
                int count = 0;
                for (int j = 0; j < chars.length; j++) {
                    BigInteger tempBI = BigInteger.valueOf(primArr[chars[j] - 32]);
                    if (bigInteger.mod(tempBI).compareTo(BigInteger.ZERO) != 0) {
                        bigInteger = bigInteger.multiply(tempBI);
                        count++;
                    }
                }

                if(max < count) {
                    max = count;
                    leader = str;
                } else if(max == count && leader.compareTo(str) > 0) {
                    leader = str;
                }

            }

            System.out.println("#" + test_case + " " + leader);
        }
    }

}
