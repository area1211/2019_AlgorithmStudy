package datastructure.linkedlist;

import java.util.*;

public class Client {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList();
        dll.addLast(10);
        dll.addLast(20);
        dll.addLast(30);
        dll.addFirst(0);
        dll.addLast(-10);
        dll.addLast(-20);
        dll.addLast(-30);
        dll.addLast(-40);


        System.out.println(dll);
        System.out.println(dll.get(3));
        System.out.println(dll.get(1));

        System.out.println(dll.removeFirst());
        System.out.println(dll);
        System.out.println(dll.remove(1));
        System.out.println(dll.remove(4));
        System.out.println(dll);
        System.out.println(dll.reverseToString());

        ArrayList<Integer> arrayList;
        Stack stack;


        StringTest stringTest = new StringTest("hello");
        stringTest.changeCharAt(2, 'k');
        System.out.println(stringTest);

        StringBuilder sb = new StringBuilder("hello");
        sb.insert(3, "kkkkk");
        System.out.println(sb.toString());


    }

    static class StringTest {
        private final char[] value;

        StringTest(String str) {
            value = str.toCharArray();
        }

        public void changeCharAt(int index, char ch) {
            value[index] = ch;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < value.length; i++) {
                sb.append(value[i]);

            }
            return sb.toString();
        }
    }

}
