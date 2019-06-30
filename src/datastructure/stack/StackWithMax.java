package datastructure.stack;

import java.util.*;

// TODO: 2019-06-30
class StackWithMax {
    // main stack 
    static Stack<Integer> mainStack = new Stack<Integer>();

    // 최대값 찾기 위한 스택
    static Stack<Integer> trackStack = new Stack<Integer>();

    static void push(int x) {
        mainStack.push(x);
        if (mainStack.size() == 1) {
            trackStack.push(x);
            return;
        }

        // If current element is greater than
        // 현재 엘리먼트가 track stack 의 최상단 엘리먼트보다 크다면
        // 현재 엘리먼트를 track stack 에 push 한다.
        if (x > trackStack.peek())
            trackStack.push(x);
        else
            trackStack.push(trackStack.peek());
    }

    static int getMax() {
        return trackStack.peek();
    }

    static void pop() {
        mainStack.pop();
        trackStack.pop();
    }

    public static void main(String[] args) {
        StackWithMax s = new StackWithMax();
        s.push(20);
        System.out.println(s.getMax());
        s.push(10);
        System.out.println(s.getMax());
        s.push(50);
        System.out.println(s.getMax());
    }
}