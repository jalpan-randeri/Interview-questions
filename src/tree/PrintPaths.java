package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jalpanranderi on 11/6/14.
 */
public class PrintPaths {

    public static void main(String[] args) {
        Node root = new Node(2);
        root.insert(4);
        root.insert(3);
        root.insert(5);
        root.insert(-1);
        root.insert(1);
        root.insert(0);

        System.out.println(root);

        printPaths(root);

        System.out.println(isBST(root));

        root = new Node(2);
        root.left = new Node(3);

        System.out.println(isBST(root));

    }


    private static boolean isBST(Node node){
        return isBstHelper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBstHelper(Node node, int min, int max) {
        if(node == null) {
            return true;
        }else if(node.data < min || node.data > max) {
            return false;
        }else{
            boolean left =  isBstHelper(node.left, min, node.data);
            boolean right = isBstHelper(node.right, node.data + 1, max);

            return left && right;
        }

    }


    private static void printPaths(Node node){
        int[] path = new int[100];
        printPathsHelper(node, path, 0);
    }

    private static void printPathsHelper(Node node, int[] path, int length) {
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            path[length] = node.data;
            length++;
            printArray(path, length);
        }else{
            path[length] = node.data;
            length++;
            printPathsHelper(node.left, path, length);
            printPathsHelper(node.right, path, length);
        }

    }

    private static void printArray(int[] path, int len){
        for(int i = 0; i < len; i++){
            System.out.printf("%3d",path[i]);
        }
        System.out.println();
    }


    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public void insert(int key){
            insertHelper(key, this);
        }

        private Node insertHelper(int key, Node node) {
            if(node == null){
                return new Node(key);
            }else if(node.data > key) {
                    node.left = insertHelper(key, node.left);
            }else {
                node.right = insertHelper(key, node.right);
            }

            return node;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
