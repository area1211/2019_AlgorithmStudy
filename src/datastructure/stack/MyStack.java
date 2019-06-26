package datastructure.stack;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Stack;

public class MyStack<T> {

    private static class Node<T> {
        private T item;
        private Node prev;
        private Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

//    private T[] elementData;
    private Object[] elementData;
    private int top;

    private int size;

    public MyStack(int capacity){
        elementData = new Object[capacity];
    }

    // push
    public T push(T item){
        elementData[top++] = item;

        size++;

        return item;
    }

    // pop
    public T pop(){
        T obj = peek();

        top--;
        return obj;
    }

    // peek
    public T peek() {
        return (T)elementData[top - 1];
    }

    // empty

    // search

    // size
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.isEmpty();
        stack.empty();

        MyStack<Integer> myStack = new MyStack(10);
        myStack.push(10);
        System.out.println(myStack.peek());

    }

}
