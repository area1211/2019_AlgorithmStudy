package others;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p2 {

    static int max = Integer.MIN_VALUE;
    static Map<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Tree root = new Tree(4);
        root.l = new Tree(5);
        root.r = new Tree(6);
        root.r.l = new Tree(1);
        root.r.r = new Tree(6);
        root.l.l = new Tree(4);
        root.l.l.l = new Tree(5);

        int answer = solution(root);
        System.out.println(answer);
//        int answer = solution2(root);
//        System.out.println(answer);


    }

//    public static int solution(Tree T) {
//
////        preOrder(T, new HashMap<>());
//
//
//        return preOrderTest(T, new HashMap<>());
//    }
//
//    public static void preOrder(Tree root, HashMap<Integer, Integer> hashMap) {
//
//        if (root == null) {
//            max = Math.max(max, hashMap.size());
//            return;
//        }
//
//
//        hashMap.put(root.x, 1);
////        System.out.print(root.x + " ");
//
//        preOrder(root.l, hashMap);
//        preOrder(root.r, hashMap);
//
//
//        hashMap.remove(root.x);
//    }

    public static int solution(Tree root) {
        if (root == null) {
            return hashMap.size();
        }

        int a, b;
        if (hashMap.containsKey(root.x)) {
            a = solution(root.l);
            b = solution(root.r);
        } else {
            hashMap.put(root.x, 1);
            a = solution(root.l);
            b = solution(root.r);
            hashMap.remove(root.x);
        }

        return a > b ? a : b;
    }

//    public static int solution2(Tree r) {
//        if (r == null) {
//            return hashMap.size();
//        }
//
//        if (hashMap.containsKey(r.x)) {
//            int a = solution(r.l);
//            int b = solution(r.r);
//            return a > b ? a : b;
//        } else {
//            hashMap.put(r.x, 1);
//            int a = solution(r.l);
//            int b = solution(r.r);
//            hashMap.remove(r.x);
//            return a > b ? a : b;
//        }
//    }


    static class Tree {
        public int x;
        public Tree l;
        public Tree r;

        public Tree(int x) {
            this.x = x;
        }

        public Tree(int x, Tree l, Tree r) {
            this.x = x;
            this.l = l;
            this.r = r;
        }
    }
}
