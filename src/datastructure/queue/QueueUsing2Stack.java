package datastructure.queue;

import java.util.Stack;

public class QueueUsing2Stack<T> {

    Stack<T> stack1 = new Stack<>();
    Stack<T> stack2 = new Stack<>();

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public void enqueue(T e) {
        stack1.push(e);
    }
    
    public T dequeue(){

//        int size = stack1.size();
//        if(size > 0) {
//            for(int i=0; i<size; i++){
//                stack2.push(stack1.pop());
//            }
//        }

        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public T front() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public static void main(String[] args) {
        QueueUsing2Stack<Character> queue = new QueueUsing2Stack();
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.enqueue('d');
        queue.enqueue('e');

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue('f');
        queue.enqueue('g');

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
