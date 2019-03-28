package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// TODO: 2019-03-28  
public class no3190_뱀 {

    static final int UP = 0, LEFT = 1, DOWN = 2, RIGHT = 3;
    static final int APPLE = 4, EMPTY = 5;

    static class Pair {
        int second;
        char direction;

        Pair(int second, char direction) {
            this.second = second;
            this.direction = direction;
        }
    }

    static class Position {
        int r, c;

        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Snake {
        int curDirection;
        Position head, tail;

        Snake() {
            curDirection = RIGHT;
            head = new Position(1, 1);
            tail = new Position(1, 1);
        }

        void turn(char direction) {
            if (direction == 'L') { // 왼쪽으로
                snake.curDirection = (snake.curDirection + 1) % 4;
            } else { // 오른쪽으로
                snake.curDirection = (snake.curDirection + 3) % 4;
            }
        }

        void go(Position position) {
            go(position, curDirection);
        }

        void go(Position position, int direction) {
            switch (direction) {
                case UP:
                    position.r += -1;
                    break;
                case DOWN:
                    position.r += 1;
                    break;
                case LEFT:
                    position.c += -1;
                    break;
                case RIGHT:
                    position.c += 1;
                    break;
            }
        }

        void moveHead() {
            go(head);
        }

        void moveTail(int direction) {
            go(tail, direction);
        }

    }

    static int[][] map = new int[101][101];
    static LinkedList<Pair> directionInfo = new LinkedList<>();
    static Snake snake = new Snake();

    static int N, time = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 맵 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = EMPTY;
            }
        }

        // 사과의 위치
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = APPLE;
        }

        // 방향 전환 정보
        int L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            directionInfo.add(new Pair(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }

        System.out.println(play());

    }

    static int play() {
//        int time = 0;

        map[snake.head.r][snake.head.c] = snake.curDirection;
        Pair nextDirection = directionInfo.poll();
        while (true) {
            time++;
            snake.moveHead();

            // 벽 또는 자기 자신과 부딪혔을 때 break
            if(!isValidPostion(snake.head.r, snake.head.c)) break;

            // 사과가 없으면 몸 길이를 줄여서 꼬리가 위치한 칸을 비워준다.
            if (map[snake.head.r][snake.head.c] != APPLE) {
                int originTailR = snake.tail.r, originTailC = snake.tail.c;
                snake.moveTail(map[snake.tail.r][snake.tail.c]);
                map[originTailR][originTailC] = EMPTY;
            }

            // 방향 전환
            if (time == nextDirection.second) {
                snake.turn(nextDirection.direction);
                if(!directionInfo.isEmpty())
                    nextDirection = directionInfo.poll();
            }

            map[snake.head.r][snake.head.c] = snake.curDirection;
//            printMap();
        }

        return time;
    }

    static boolean isValidPostion(int r, int c) {
        return r >= 1 && r <= N && c >= 1 && c <= N && map[r][c] >= APPLE && map[r][c] <= EMPTY;
    }

    static void printMap() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println("current time: " + time);
        System.out.println("current head position: " + snake.head.r + ", " + snake.head.c);
        System.out.println("current tail position: " + snake.tail.r + ", " + snake.tail.c);
        System.out.println();
    }
}
