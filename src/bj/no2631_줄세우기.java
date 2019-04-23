package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: 2019-04-23
public class no2631_줄세우기 {

    static int[] kids = new int[201];
    static int[] dp = new int[201];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        for (int i = 1; i <= N; i++) {
            kids[i] = Integer.parseInt(br.readLine());
        }


//        List<Integer> list = new ArrayList<>();
//        list.add(kids[1]);

        dp[0] = kids[1];
        int count = 1;

        for (int i = 2; i <= N; i++) {

//            int searchResult = binarySearch(list, kids[i]);
//            if (searchResult + 1 < list.size() && list.get(searchResult + 1) > kids[i]) {
//                list.set(searchResult + 1, kids[i]);
//            } else {
//                list.add(kids[i]);
//            }

            //ArrayList를 이용한 이진탐색
//            int searchResult = Arrays.binarySearch(list.toArray(), kids[i]);
//            searchResult = -searchResult - 1;
//
//            if (searchResult < list.size() && list.get(searchResult) > kids[i]) {
//                list.set(searchResult, kids[i]);
//            }
//            else {
//                list.add(kids[i]);
//            }

            // 배열을 이용한 이진탐색
            int searchResult = Arrays.binarySearch(dp, 0, count - 1, kids[i]);
            searchResult = -searchResult - 1;
            if (searchResult < count && dp[searchResult] > kids[i]) {
                dp[searchResult] =  kids[i];
            }
            else {
                dp[count++] = kids[i];
            }
        }

//        int LISCount = list.size();
        int LISCount = count;

        System.out.println(N - LISCount);
    }

    static int binarySearch(List<Integer> list, int target) {
        int first = 0;
        int last = list.size() - 1;
        int mid;

        while (first <= last) {
            mid = (first + last) / 2;
            int temp = list.get(mid);

            if (temp < target)
                first = mid + 1;
            else
                last = mid - 1;
        }

        return last;
    }
}
