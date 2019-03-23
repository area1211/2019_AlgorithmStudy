package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no1966_프린터큐 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        LinkedList<Paper> queue = new LinkedList<>();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                queue.add(new Paper(j, Integer.parseInt(st.nextToken())));
            }


            boolean flag = false;
            int cnt = 0;
            while (queue.size() != 0) {
                Paper first = queue.peek();
                for (Paper target : queue) {
                    if (first.priorty < target.priorty) {
                        queue.poll();
                        queue.addLast(first);
                        flag = true;
                        break;
                    }
                }

                if(flag) {
                    flag = false;
                    continue;
                }

                cnt++;
                queue.poll();

                if(first.num == M) {
                    System.out.println(cnt);
                }

            }

            queue.clear();
        }

    }
}

class Paper {
    int num;
    int priorty;

    Paper(int num, int priorty) {
        this.num = num;
        this.priorty = priorty;
    }
}
