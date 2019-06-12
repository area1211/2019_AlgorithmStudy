package datastructure.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BST {

    private Node root;

    public void addBST(int item) {
        root = add(root, item);
    }

    private Node add(Node current, int item) {
        // leaf node 에 도달하면 새로운 노드를 생성해서 해당 위치에 삽입한다.
        if (current == null) {
            return new Node(item);
        }

        if (item < current.data) {
            current.left = add(current.left, item);
        } else if (item > current.data) {
            current.right = add(current.right, item);
        } else {
            return current;
        }

        return current;
    }

    public boolean contains(int item) {
        return containsNode(root, item);
    }

    private boolean containsNode(Node current, int item) {
        if (current == null) {
            return false;
        }

        if (item == current.data) {
            return true;
        }

        return item < current.data
                ? containsNode(current.left, item)
                : containsNode(current.right, item);
    }

    public void delete(int item){
        root = deleteNode(root, item);
    }

    private Node deleteNode(Node current, int item) {
        if (current == null) {
            return null;
        }

        if (item == current.data) {
            // 찾은 노드 삭제 하는 과정...

            // 자식이 없는 leaf node 일 때,
            if (current.left == null && current.right == null){
                return null;
            }

            // 왼쪽 자식만 있을 때
            if (current.right == null){
                return current.left;
            }

            // 오른쪽 자식만 있을 때
            if (current.left == null){
                return current.right;
            }

            // 오른쪽 서브 트리에서 가장 작은 값을 찾는다.
            int smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            // 그리고 가장 작은 값은 원래 위치에서 지운다.
            current.right = deleteNode(current.right, smallestValue);
            return current;

        }

        if (item < current.data) {
            current.left = deleteNode(current.left, item);
            return current;
        }

        current.right = deleteNode(current.right, item);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.data : findSmallestValue(root.left);
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(" " + node.data);
            traverseInOrder(node.right);
        }
    }

    public void traverse(){
        traverseInOrder(root);
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.println(" " + node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.println(" " + node.data);
        }
    }

    public void traverseLevelOrder(){
        Queue<Node> nodes = new LinkedList<>();

    }

    private static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this(data, null, null);
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        BST bst = new BST();
        bst.addBST(6);
        bst.addBST(4);
        bst.addBST(8);
        bst.addBST(3);
        bst.addBST(5);
        bst.addBST(7);
        bst.addBST(9);

        System.out.println(bst.contains(8));
        bst.delete(8);
        System.out.println(bst.contains(8));

        System.out.println(bst.contains(11));


        bst.traverse();




    }

}
