package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2019-03-29
// https://www.acmicpc.net/problem/1057
// 시뮬레이션
public class no1057_토너먼트 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());

        int round = 1;

        while ((kim = (kim + 1) / 2) != (lim = (lim + 1) / 2)) {
            round++;
        }

        System.out.println(round);
    }
}
