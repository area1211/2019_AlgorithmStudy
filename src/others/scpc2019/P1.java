package others.scpc2019;

import java.util.Scanner;

public class P1 {
    static int Answer;

    public static void main(String args[]) throws Exception {
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {

            // Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////

            Answer = solution(sc.nextInt(), sc.nextInt());

            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }

    static int[] dp = new int[1000001];

    static int solution(int n1, int n2) {
        int sum = 0;
        for (int i = n1; i <= n2; i++) {
            if (dp[i] == 0)
                dp(i, 0);

            sum += dp[i];
        }

        return sum;
    }

    static int dp(int n1, int count) {
        if (dp[n1] != 0) return count + dp[n1];

        int temp;
        if (n1 == 1) {
            return count;
        } else if (n1 % 2 == 0) {
            temp = dp(n1 / 2, count + 1);
        } else {
            temp = dp(n1 + 1, count + 1);
        }
        dp[n1] = temp - count;
        return temp;
    }
}
