package others.ebay;

import java.util.*;

public class p1 {

    public static void main(String[] args) {
        String str1 = "four";
        String str2 = "oneone";
        System.out.println(str2.compareTo(str1));


        System.out.println();
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numbers2 = {4, 5, 11};
        new p1().solution(numbers2);



    }


    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        String[] arrTest = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] arr = {"j", "e", "i", "h", "c", "b", "g", "f", "a", "d"};

        LinkedList<Node> list = new LinkedList<>();

        for (int i = 0; i < numbers.length; i++) {
            StringBuilder sb = new StringBuilder();
            int temp = numbers[i];

            while(temp != 0) {
                sb.insert(0, arr[temp % 10]);
                temp /= 10;
            }

            System.out.println(sb.toString());
            list.add(new Node(numbers[i], sb.toString()));
        }

        list.sort((Comparator.comparing(o -> o.str)));
//        list.sort(((o1, o2) -> {
//            if(o1.str.length() < o2.str.length()) return 1;
//            else if(o1.str.length() > o2.str.length()) return  -1;
//            else
//                return o1.str.compareTo(o2.str);
//        }));

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).num;
        }

        for (int num :
                answer) {
            System.out.println(num);

        }

        return answer;
    }

    static class Node {
        private int num;
        private String str;

        public Node(int num, String str) {
            this.num = num;
            this.str = str;
        }
    }
}
