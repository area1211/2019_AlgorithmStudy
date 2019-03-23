package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2455_지능형기차 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] getOff = new int[4];
        int[] getOn = new int[4];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            getOff[i] = Integer.parseInt(st.nextToken());
            getOn[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for (int i = 0; i < 4; i++) {
            max = Math.max(max, max - getOff[i] + getOn[i]);
        }

        System.out.println(max);



    }
}
