package elements_of_programming_interview.chapter14;

/**
 * Created by jalpanranderi on 11/23/14.
 */
public class BinaryTreeChecker {

    private static class Node{
        int data;
        Node left;
        Node right;
        Node parent;

        public Node(int data) {
            this.data = data;
        }

        public void insert(int key){
            insertHelper(this, key);
        }

        private Node insertHelper(Node node, int key) {
            if(node == null){
                return new Node(key);
            }else if(node.data > key){
                node.left = insertHelper(node.left, key);
                node.left.parent = node;
            }else{
                node.right = insertHelper(node.right, key);
                node.right.parent = node;
            }
            return node;
        }

        @Override
        public String toString() {
            return "{" +
                    "" + data +
                    ", left " + left +
                    ", right " + right +
                    '}';
        }
    }


    public static void main(String[] args) {
        Node root = new Node(0);
        root.insert(-4);
        root.insert(4);
        root.insert(-3);
        root.insert(1);
        root.insert(-2);
//        root.left.right.left = new Node(10);

        System.out.println(root);

        System.out.println(isBinaryTree(root));

        System.out.println(getSuccessor(root.right));

        System.out.println(findMinimumNode(root.right));
        System.out.println(delete(root, -2));

    }

    public static boolean isBinaryTree(Node node){
        return isBinaryTreeHelper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBinaryTreeHelper(Node n, int low, int high){
        if(n == null){
            return true;
        }else if(n.data < high && n.data > low){
            return  isBinaryTreeHelper(n.left,low, n.data) &&
                    isBinaryTreeHelper(n.right, n.data, high);
        }
        return false;
    }




    public static Node getSuccessor(Node n){
        if(n.right != null){
            return getLeftMostNode(n.right);
        }else {
            Node curr = n;
            Node par = n.parent;

            while(par != null && par.left != n){
                n = par;
                par = n.parent;
            }

            return par;
        }
    }
    private static Node getLeftMostNode(Node n){
        if(n.left != null){
            return getLeftMostNode(n.left);
        }else{
            return n;
        }
    }


    public static Node delete(Node node, int data){

        if(node == null){
            return node;
        }else if(data > node.data){
            node.right =  delete(node.right, data);
        }else if(data < node.data){
            node.left = delete(node.left, data);
        }else if(node.left == null && node.right == null){
            // case 1. leaf node
            node = null;
        }else if(node.right == null){
            // case 2.  one child
            node =  node.left;
        }else if(node.left == null){
            node = node.right;
        }else{
            // case 3. two childers
            Node temp = findMinimumNode(node.right);
            node.data = temp.data;
            node.right = delete(node.right, temp.data);
        }


        return node;
    }



    private static Node findMinimumNode(Node n){
        while(n.left != null){
            n = n.left;
        }
        return n;
    }

}
