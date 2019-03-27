package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class no1094_막대기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int bar = 64;
        int cnt = 0;

        while (X != 0) {

            if (X < bar) {
                bar /= 2;
            } else {
                X -= bar;
                cnt++;
            }

        }

        System.out.println(cnt);
    }
}
