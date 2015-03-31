package tree;

/**
 * Created by jalpanranderi on 10/25/14.
 */
public class TreeHeight {


    public static void main(String[] args) {
        Node root = new Node(1);
        root = insert(2,root);
        root = insert(4,root);
        root = insert(1,root);
        root = insert(3,root);
        root = insert(-1,root);
        root = insert(0,root);
        root = insert(-1,root);
        root = insert(-1,root);


        System.out.println(getHeight(root));

    }


    private static int getHeight(Node root){
        if(root == null){
            return 0;
        }else{
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }

    public static class Node{

        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }


    public static Node insert(int data, Node root){
        if(root == null){
            return new Node(data);
        }else{
            if(data < root.key){
                root.left = insert(data, root.left);
            }else{
                root.right = insert(data, root.right);
            }

            return root;
        }
    }




}
