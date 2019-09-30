package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// TODO: 2019-05-21
// KMP 알고리즘 구현해보기
public class no5582_공통부분문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();

        if (s.length() < p.length()) {
            String temp = s;
            s = p;
            p = temp;
        }

//        System.out.println(s);
//        System.out.println(p);

        for (int i = p.length(); i >= 1; i--) {
            for (int j = 0; j < p.length(); j++) {
                if (j + i >= p.length()) continue;

                int lastIndex = kmp(s, p.substring(j, j + i));
                if (lastIndex >= 0) {
                    System.out.println(lastIndex + 1);
                    return;
                }
            }
        }

        System.out.println(0);

    }

    public static int[] getPi(String p) {
        int m = p.length();
        int j = 0;

        int[] pi = new int[m];
        for (int i = 1; i < m; i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j))
                j = pi[j - 1];
            if (p.charAt(i) == p.charAt(j))
                pi[i] = ++j;

        }

        return pi;
    }

    public static int kmp(String s, String p) {
        int[] pi = getPi(p);

        int n = s.length(), m = p.length(), j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j))
//                j = pi.size() > j - 1 ? pi.get(j - 1) : 0;
                j = pi[j - 1];

            if (s.charAt(i) == p.charAt(j)) {
                if (j == m - 1) { // 문자열의 끝까지 비교했다면 p 문자열이 s에 존재한다는 것이다.
//                    ans.add(i - m + 1 + 1); // s 문자열에서 p 문자열의 시작 위치를 추가한다.
//                    j = pi.size() > j ? pi.get(j) : 0;
//                    j = pi[j];

                    return j;

                } else {
                    j++;
                }
            }
        }
        return -1;
    }


}
