import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class no2293_동전1 {

    static int k;
    static int[] coin;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        k = sc.nextInt();

        coin = new int[n];

        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        int result = 0;
        result += solution(coin[0], 0);
        result += solution(coin[1], 0);
        result += solution(coin[2], 0);

        System.out.print(result);
    }

    static int solution(int c, int sum) {
        if (sum + c == k) return 1;
        else if (sum + c > k) return 0;

        int result = 0;
        result += solution(coin[0], sum + c);
        result += solution(coin[1], sum + c);
        result += solution(coin[2], sum + c);

        return result;
    }
}
