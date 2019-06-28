package datastructure.linkedlist;

// 단일 연결 리스트
public class SingleLinkedList<T> {
    private Node head; // 첫 번째 노드를 가리키는 필드
    private Node tail; // 마지막 노드를 가리키는 필
    private int size = 0;

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addLast(10);
        singleLinkedList.addLast(20);
        singleLinkedList.addLast(30);
        singleLinkedList.addLast(40);
        singleLinkedList.addLast(50);


        singleLinkedList.printMiddle();
    }

    // 외부에서 Node 클래스에 대해 접근할 수 없도록 private 으로 선언한다.
    private class Node {
        private T data;
        private Node next;

        private Node(T d) {
            data = d;
            next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public void addFirst(T input) {
        Node newNode = new Node(input);
        newNode.next = head; // 새 노드의 다음 노드로 head를 지정한다.
        head = newNode; // 새 노드를 head로 지정한다.
        size++;
        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(T input) {
        Node newNode = new Node(input);
        if (size == 0) {
            addFirst(input);
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    // 특정 위치의 Node를 찾는 메소드.
    public Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    // 특정 위치의 엘리먼트를 가져오는 메소드.
    public T get(int index) {
        // 인덱스 범위 체크 -> 메소드 분리 해야함.
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node temp = node(index);
        return temp.data;
    }

    public void add(int k, T input) {
        if (k == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(k - 1);
            Node temp2 = temp1.next;
            Node newNode = new Node(input);

            temp1.next = newNode; // k-1번째 노드 -> 삽입할 노드
            newNode.next = temp2; // 삽입할 노드 -> 원래 k번째 노드
            size++;

            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    public T removeFirst() {
        T returnData = head.data;
        head = head.next;

        size--;
        return returnData;
    }

    public T remove(int k) {
        if (k == 0) return removeFirst();


        Node temp = node(k - 1);
        Node todoDeleted = temp.next;
        T returnData = todoDeleted.data;

        temp.next = todoDeleted.next;

//        if (todoDeleted == tail) { // k 번째 node 가 tail 이라면
//            tail = temp; // k-1 번째 node 를 tail 로 지정한다.
//        }

        if (todoDeleted.next == null) { // k 번째 node 의 next 가 null 이라면 k 번째 node 가 tail 이라는 뜻이다.
            tail = temp; // 따라서 k-1 번째 node 를 tail 로 지정한다.
        }

        todoDeleted.data = null;
        todoDeleted.next = null;

        size--;
        return returnData;
    }

    void printMiddle()
    {
        Node slow_ptr = head;
        Node fast_ptr = head;
        if (head != null)
        {
            while (fast_ptr != null && fast_ptr.next != null)
            {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("The middle element is [" +
                    slow_ptr.data + "] \n");
        }
    }


    @Override
    public String toString() {
        if (head == null) return "[]";

        Node temp = head;
        StringBuilder sb = new StringBuilder("[");

        // 마지막 노드의 next 는 null 이기 때문에 마지막 노드는 제외된다.
        while (temp.next != null) {
            sb.append(temp.data);
            sb.append(", ");
            temp = temp.next;
        }

        // 따라서 마지막 노드를 출력 결과에 포함시킨다.
        sb.append(temp.data);
        sb.append("]");

        return sb.toString();
    }
}
