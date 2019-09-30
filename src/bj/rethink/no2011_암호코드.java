package bj.rethink;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

// TODO: 2019-04-17
public class no2011_암호코드 {

    static String password;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        password = br.readLine();

//        go(password.charAt(0) + "", 1);


        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(password.charAt(0) - 48);
        for (int i = 1; i < password.length(); i++) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                int cur = queue.poll();

                char c = password.charAt(i);
                if (c - 48 > 0)
                    queue.add(password.charAt(i) - 48);

                int added = Integer.parseInt(cur + "" + c);
                if (added >= 1 && added <= 26)
                    queue.add(added);
            }
        }
        System.out.println(queue.size());
    }


    static void go(String cur, int index) {
        if (index == password.length()) {
            count++;
            return;
        }

        int left = Integer.parseInt(password.charAt(index) + "");
        if (left >= 1 && left <= 26)
            go(password.charAt(index) + "", index + 1);

        int right = Integer.parseInt(cur + password.charAt(index));
        if (right >= 1 && right <= 26)
            go(cur + password.charAt(index), index + 1);
    }
}
