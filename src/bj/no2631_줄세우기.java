package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// TODO: 2019-04-23
public class no2631_줄세우기 {

    static int[] kids = new int[201];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(10>>1);
        int N = Integer.parseInt(br.readLine());


        for (int i = 1; i <= N; i++) {
            kids[i] = Integer.parseInt(br.readLine());
        }


        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {

            int searchResult = binarySearch(list, kids[i]);
            if (searchResult + 1 < list.size() && list.get(searchResult + 1) > kids[i]) {
                list.set(searchResult + 1, kids[i]);
            } else {
                list.add(kids[i]);
            }

        }

        int LISCount = list.size();

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
