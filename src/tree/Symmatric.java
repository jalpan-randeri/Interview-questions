package tree;

/**
 * Created by jalpanranderi on 12/3/14.
 */
public class Symmatric {
    public static void main(String[] args) {
//        Node root = new Node(4);
//        root.left = new Node(2);
//        root.right = new Node(2);
//
//        root.left.left = new Node(3);
//        root.right.right = new Node(3);
//
////        root.left.right = new Node(1);
////        root.right.left = new Node(1);


        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);

        root.left.left = new Node(3);
        root.left.left.left = new Node(4);
        root.left.left.right = new Node(5);



        System.out.println(isSymmatric(root));
    }


    public static boolean isSymmatric(Node root) {
        return root == null || isSymmatricHelper(root.left, root.right);
    }

    private static boolean isSymmatricHelper(Node left, Node right){
        if(left != null && right != null){
            return left.data == right.data &&
                    isSymmatricHelper(left.left, right.right) &&
                    isSymmatricHelper(left.right, right.left);
        }

        return left == null && right == null;
    }


    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
