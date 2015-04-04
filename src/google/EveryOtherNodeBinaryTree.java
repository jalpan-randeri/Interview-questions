package google;


/**
 * Given a binary tree print the every other child in
 * the inorder tree traversal
 *
 *
 *             5
 *           /   \
 *          3     6
 *         / \     \
 *        1   4     8
 *       / \   \     \
 *      0   2   4     9
 *
 * Created by jalpanranderi on 4/4/15.
 */
public class EveryOtherNodeBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.left.left = new Node(0);
        root.left.left.right = new Node(2);
        root.left.right = new Node(4);
        root.left.right.right = new Node(4);

        root.right = new Node(6);
        root.right.right = new Node(8);
        root.right.right.right = new Node(9);

        printOtherChild(root);
    }


    private static void printOtherChild(Node root){
        printHelper(root.left, false);
        printHelper(root.right, true);
    }

    private static void printHelper(Node curr, boolean flag) {
        if(curr != null) {
            printHelper(curr.left, !flag);
            printHelper(curr.right, !flag);
            if(flag){
                System.out.println(curr.data);
            }
        }

    }


    public static class Node{
        int data;
        Node left;
        Node right;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            if (data != node.data) return false;
            if (left != null ? !left.equals(node.left) : node.left != null) return false;
            return !(right != null ? !right.equals(node.right) : node.right != null);

        }

        @Override
        public int hashCode() {
            int result = data;
            result = 31 * result + (left != null ? left.hashCode() : 0);
            result = 31 * result + (right != null ? right.hashCode() : 0);
            return result;
        }

        public Node(int data) {
            this.data = data;
        }
    }
}
