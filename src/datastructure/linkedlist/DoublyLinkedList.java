package datastructure.linkedlist;

import java.util.Arrays;

public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    private int size;


    private static class Node<T> {
        private T item;
        private Node<T> prev, next;

        public Node(T item) {
            this.item = item;
            prev = next = null;
        }

        public Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // addFirst
    public void addFirstTest(T input) {
        Node<T> newNode = new Node<>(input);
        newNode.next = head;

        head = newNode;
        if (head.next == null) {
            tail = head;
        } else {
            head.next.prev = head;
        }

        size++;
    }

    public void addFirst(T input) {
        Node<T> newNode = new Node<>(input, null, head);
        if (head != null)
            head.prev = newNode;
        else // head == null 이면 tail == null 도 널이다?
            tail = newNode;

        head = newNode;
        size++;
    }

    // addLast
    public void addLast(T input) {
        Node<T> newNode = new Node<>(input, tail, null);

        if (tail != null) {
            tail.next = newNode;
        } else { // tail == null
            head = newNode;
        }

        tail = newNode;
        size++;
    }

    // node
    Node<T> node(int index) {
        Node<T> tmp;
        // 1110(14) -> 0111(7)
        // 1111(15) -> 0111(7)
        if (index > size / 2) {
            tmp = tail;
            for (int i = size - 1; i > index; i--) {
                tmp = tmp.prev;
            }
//            return tmp;
        } else {
            tmp = head;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
//            return tmp;
        }
        return tmp;
    }

    // get
    public T get(int index) {
        // checkElementIndex(index);
        return node(index).item;
    }

    // removeFirst
    public T removeFirst() {
        if(head == null) return null;

        Node<T> temp = head;

        head = head.next;
        head.prev = null;
        temp.next = null;
        size--;

        return temp.item;
    }

    // remove
    public T remove(int index){
        if(index == 0) return removeFirst();

        Node<T> tmp = node(index - 1);
        Node<T> nodeToRemove = tmp.next;
        T dataToReturn = nodeToRemove.item;

        // (index-1) <-> (index+1)
        if(nodeToRemove == tail) {
            tail = tmp;
        }

        tmp.next = nodeToRemove.next;
        tmp.next.prev = tmp;

        nodeToRemove.item = null;
        nodeToRemove.prev = null;
        nodeToRemove.next = null;

        size--;
        return dataToReturn;
    }

    public static int kthSmallest(Integer [] arr,
                                  int k)
    {
        // 파리머터로 주어진 배열을 정렬한다.
        Arrays.sort(arr);

        // 정렬된 배열에서 K번째 원소를 반환한다.
        return arr[k-1];
    }

    // toString
    @Override
    public String toString() {
        if (head == null) return "[]";

        StringBuilder sb = new StringBuilder("[");

        Node tempPointer = head;

        while (tempPointer.next != null) {
            sb.append(tempPointer.item);
            sb.append(", ");
            tempPointer = tempPointer.next;
        }

        sb.append(tempPointer.item);
        sb.append("]");

        return sb.toString();
    }

    public String reverseToString() {
        if (tail == null) return "[]";

        StringBuilder sb = new StringBuilder("[");

        Node tempPointer = tail;

        while (tempPointer.prev != null) {
            sb.append(tempPointer.item);
            sb.append(", ");
            tempPointer = tempPointer.prev;
        }

        sb.append(tempPointer.item);
        sb.append("]");

        return sb.toString();
    }
}
