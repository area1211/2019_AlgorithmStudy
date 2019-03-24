package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no1021_회전하는큐 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        st = new StringTokenizer(br.readLine());

        LinkedList<Integer> circularQueue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            circularQueue.add(i);
        }
        LinkedList<Integer> queueToPick = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            queueToPick.add(Integer.parseInt(st.nextToken()));
        }

        while (queueToPick.size() != 0) {

            int index = circularQueue.indexOf(queueToPick.peek()) + 1;
            int leftCnt = index - 1;
            int rightCnt = circularQueue.size() - index + 1;

            if (leftCnt > rightCnt) {

                for (int i = 0; i < rightCnt; i++) {
                    int last = circularQueue.pollLast();
                    circularQueue.addFirst(last);
                }

            } else {

                for (int i = 0; i < leftCnt; i++) {
                    int first = circularQueue.pollFirst();
                    circularQueue.addLast(first);
                }

            }

            cnt += leftCnt > rightCnt ? rightCnt : leftCnt;
            circularQueue.poll();
            queueToPick.poll();
        }

        System.out.println(cnt);

    }
}
