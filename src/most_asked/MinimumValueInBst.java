package most_asked;

/**
 * Created by jalpanranderi on 11/8/14.
 */
public class MinimumValueInBst {

    public static void main(String[] args) {

        Node root = new Node(2);
        root.insert(3);
        root.insert(1);
        root.insert(0);
        root.insert(4);
        root.insert(5);
        root.insert(6);

        System.out.println(getMinimum(root));

    }


    private static int getMinimum(Node node){

        int min = -1;

        while(node != null){
            min = node.data;
            node = node.left;
        }

        return min;
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
            }else{
                if(key < node.data) {
                    node.left = insertHelper(key, node.left);
                }else{
                    node.right = insertHelper(key, node.right);
                }

            }

            return node;
        }
    }
}
