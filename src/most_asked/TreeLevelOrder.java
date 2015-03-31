package most_asked;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * Given a binary tree of integers, print it in level order. The output will contain space between the numbers in
 * the same level, and new line between different levels.
 * - See more at: http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.BgLHYvZ6.dpuf
 *
 *
 * Created by jalpanranderi on 11/4/14.
 */
public class TreeLevelOrder {

    public static void main(String[] args) {
        Node root = new Node(1);
//        root.insert(2);
//        root.insert(3);
//        root.insert(4);
//        root.insert(5);
//        root.insert(6);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);


//        System.out.println(root);

        treeLevelOrder(root);

    }


    // time  = O(n)
    // space = O(n)
    private static void treeLevelOrder(Node n){
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(n);

        int nextNode = 0;
        int currentNode = 1;
        Node curr;
        while(!nodes.isEmpty()){
           curr = nodes.remove();
            currentNode--;
            System.out.printf("%3d", curr.data);
            if(curr.left != null){
                nodes.add(curr.left);
                nextNode++;
            }

            if(curr.right != null){
                nodes.add(curr.right);
                nextNode++;
            }

            if(currentNode == 0){
                currentNode = nextNode;
                nextNode = 0;
                System.out.println();
            }
        }

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


        private void insertHelper(int key, Node n){
            if(key > n.data){
                if(n.right != null){
                    insertHelper(key, n.right);
                }else{
                    n.right = new Node(key);
                }
            }else{
                if(n.left != null){
                    insertHelper(key, n.left);
                }else{
                    n.left = new Node(key);
                }
            }
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
