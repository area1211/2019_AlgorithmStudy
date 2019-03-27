package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no14891_톱니바퀴 {
    static final int NORTH = 0, SOUTH = 4, EAST = 2, WEST = 6;
    static final int N = 0, S = 1;
    static final int CLOCKWISE = 1, COUNTERCLOCKWISE = -1;

    static LinkedList<Integer>[] gearList = new LinkedList[5];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 4; i++) {
            gearList[i] = new LinkedList<>();
        }

        for (int i = 1; i <= 4; i++) {
            String gearStatus = br.readLine();
            for (int j = 0; j < 8; j++) {
                gearList[i].add(Integer.parseInt(gearStatus.charAt(j) + ""));
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            int[] rotation = new int[5];
            rotation[num] = Integer.parseInt(st.nextToken());

            for (int j = num; j >= 2; j--) {
                if (!gearList[j].get(WEST).equals(gearList[j - 1].get(EAST))) {
                    rotation[j - 1] = rotation[j] == COUNTERCLOCKWISE ? CLOCKWISE : COUNTERCLOCKWISE;
                } else {
                    break;
                }
            }

            for (int j = num; j <= 3; j++) {
                if (!gearList[j].get(EAST).equals(gearList[j + 1].get(WEST))) {
                    rotation[j + 1] = rotation[j] == COUNTERCLOCKWISE ? CLOCKWISE : COUNTERCLOCKWISE;
                } else {
                    break;
                }
            }

            for (int j = 1; j <= 4; j++) {
                rotate(j, rotation[j]);
            }

        }

        int score = 0;
        for (int i = 1; i <= 4; i++) {
            score += gearList[i].get(NORTH).equals(N) ? 0 : Math.pow(2, i - 1);
        }
        System.out.println(score);
    }

    static void rotate(int num, int direction) {

        if (direction == CLOCKWISE) { // 시계방향
            int n = gearList[num].removeLast();
            gearList[num].addFirst(n);
        } else if (direction == COUNTERCLOCKWISE) { // 반시계방향
            int n = gearList[num].removeFirst();
            gearList[num].addLast(n);
        }

    }
}
