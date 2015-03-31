package elements_of_programming_interview.chapter8;

import java.util.Stack;

/**
 * Created by jalpanranderi on 11/22/14.
 */
public class BinaryTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public void insert(int i) {
            insertHelper(i, this);
        }

        private Node insertHelper(int key, Node node) {

            if (node == null) {
                return new Node(key);
            }

            if (key < node.data) {
                node.left = insertHelper(key, node.left);
            } else {
                node.right = insertHelper(key, node.right);
            }

            return node;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.insert(1);
        root.insert(2);
        root.insert(5);
        root.insert(4);

        printInorder(root);

        System.out.println();

        printPreOrder(root);

        System.out.println();
//        print(root);
        morrisTravsal(root);
    }


    public static void printInorder(Node node) {
        Stack<Node> stack = new Stack<>();


        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.printf("%3d", node.data);
                node = node.right;
            }

        }

    }


    public static void printPreOrder(Node node) {
        Stack<Node> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                System.out.printf("%3d", node.data);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }


    public static void print(Node node) {
        if (node != null) {
            print(node.left);
            System.out.printf("%3d", node.data);
            print(node.right);
        }
    }


    public static void morrisTravsal(Node root) {
        Node current, pre;

        if (root == null)
            return;

        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.printf(" %d ", current.data);
                current = current.right;
            } else {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                // MAGIC OF RESTORING the Tree happens here:
                /* Revert the changes made in if part to restore the original
                   tree i.e., fix the right child of predecssor */
                    pre.right = null;
                    System.out.printf(" %d ", current.data);
                    current = current.right;
                } /* End of if condition pre.right == null */
            } /* End of if condition current.left == null*/
        } /* End of while */
    }
}
