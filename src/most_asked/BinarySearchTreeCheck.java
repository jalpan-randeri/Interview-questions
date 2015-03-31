package most_asked;

/**
 *
 * Given a binary tree, check whether it’s a binary search tree or not.
 * - See more at: http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.BgLHYvZ6.dpuf
 *
 *
 * Created by jalpanranderi on 11/5/14.
 */
public class BinarySearchTreeCheck {


    public static void main(String[] args) {
        Node root = new Node(1);
        root.insert(2);
        root.insert(3);
        root.insert(-1);

        System.out.println(root);

        print(root);
        System.out.println();

        System.out.println(isBinaryTree(root));

    }



    // Caution: dont try to check if root is greater than left and less than right
    //          cause it will faulty as root elemnet should be greater than entire
    //          left child tree so there is no way to check this and it bit of
    //          overhead as we need to keep track of root elemnt
    //
    //          Best strategy is to narrow down the space. as starting space
    //          -infinity to +infinity. then visit root,
    //          now recursivly call left child tree with space as
    //               -infinity  to root - 1.
    //          right with  root + 1  to +infinity
    //          if eiter of this false then given is not binary tree.

    // time  = O(n)
    // space = O(log n)
    private static boolean isBinaryTree(Node root){
        return isBinaryTreeHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBinaryTreeHelper(Node node, int min, int max) {
        if(node == null){
            return true;
        }

        if(node.data < min || node.data > max){
            return false;
        }

        return isBinaryTreeHelper(node.left, min, node.data - 1) &&
                isBinaryTreeHelper(node.right, node.data + 1, max);

    }


    private static void print(Node n){
        if(n == null){
            return;
        }


        if(n.left != null){
            print(n.left);

        }

        System.out.print(n.data);

        if(n.right != null){
            print(n.right);
        }
    }


    public static class Node{
        int data;
        Node right;
        Node left;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", right=" + right +
                    ", left=" + left +
                    '}';
        }

        public Node(int data) {
            this.data = data;
        }

        public void insert(int key){
            insertHelper(this, key);
        }

        private Node insertHelper(Node n, int key) {
            if(n == null){
                return new Node(key);
            }else if(key < n.data){
                n.left = insertHelper(n.left, key);
            }else{
                n.right = insertHelper(n.right, key);
            }

            return n;
        }
    }
}
