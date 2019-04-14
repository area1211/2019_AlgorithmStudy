package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// TODO: 2019-04-13  
public class no9205_맥주마시면서걸어가기 {


    static Map<Key, Boolean> mapVisited = new HashMap<>();
    static int startX, startY, endX, endY;

    static Key[] keyList;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int x, y;
        for (int i = 0; i < T; i++) {

            n = Integer.parseInt(br.readLine());
            keyList = new Key[n + 2];
            visited = new boolean[n + 2];

            for (int j = 0; j < n + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                keyList[j] = new Key(x, y);
            }

//            StringTokenizer st = new StringTokenizer(br.readLine());
//            x = Integer.parseInt(st.nextToken());
//            y = Integer.parseInt(st.nextToken());
//            mapVisited.put(new Key(x, y), false);
//            startX = x;
//            startY = y;
//
//            for (int j = 0; j < n; j++) {
//                st = new StringTokenizer(br.readLine());
//                x = Integer.parseInt(st.nextToken());
//                y = Integer.parseInt(st.nextToken());
//                mapVisited.put(new Key(x, y), false);
//            }
//
//            st = new StringTokenizer(br.readLine());
//            x = Integer.parseInt(st.nextToken());
//            y = Integer.parseInt(st.nextToken());
//            mapVisited.put(new Key(x, y), false);
//            endX = x;
//            endY = y;

//            System.out.println(BFS(startX, startY));
            System.out.println(BFS2(keyList[0].x, keyList[0].y));

        }

    }

    static String BFS2(int x, int y) {
        LinkedList<Key> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(new Key(x, y));

        while (!queue.isEmpty()) {
            Key k = queue.poll();
            if (k.x == keyList[n + 1].x && k.y == keyList[n + 1].y) {
                return "happy";
            }


            for (int i = 1; i < n + 2; i++) {
                if (getDistance(k, keyList[i]) <= 1000 && !visited[i]) {
                    visited[i] = true;
                    queue.add(keyList[i]);
                }
            }
        }

        return "sad";
    }

    static String BFS(int x, int y) {
        LinkedList<Key> queue = new LinkedList<>();
        mapVisited.put(new Key(x, y), true);
        queue.add(new Key(x, y));

//        for (Key key : mapVisited.keySet()) {
//            int dist = getDistance(new Key(x, y), key);
//            if (dist > 0 && dist <= 1000) {
//                queue.add(key);
//            }
//        }


        while (!queue.isEmpty()) {
            Key k = queue.poll();
            if (k.x == endX && k.y == endY)
                return "happy";

            for (Key key : mapVisited.keySet()) {
                int dist = getDistance(new Key(k.x, k.y), key);
                if (dist <= 1000 && !mapVisited.get(new Key(key.x, key.y))) {
                    mapVisited.put(new Key(key.x, key.y), true);
                    queue.add(key);
                }
            }

        }

        return "sad";
    }

    static int getDistance(Key p1, Key p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    static class Key {

        private final int x;
        private final int y;

        public Key(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Key)) return false;
            Key key = (Key) o;
            return x == key.x && y == key.y;
        }

        @Override
        public int hashCode() {
//            int result = x;
//            result = 32768 * result + y;
//            return result;

            return (x << 15) + y;
        }

    }
}
