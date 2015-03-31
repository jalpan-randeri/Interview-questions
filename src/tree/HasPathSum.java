package tree;

/**
 * Created by jalpanranderi on 11/6/14.
 */
public class HasPathSum {

    public static void main(String[] args) {
        Node root = new Node(3);
        root.insert(1);
        root.insert(2);
        root.insert(-1);
        root.insert(5);

        System.out.println(root);

        System.out.println(hasPathSum(root, 7));

    }



    private static boolean hasPathSum(Node node, int sum){
        return hasPathSumHelper(node, sum, 0);
    }

    private static boolean hasPathSumHelper(Node node, int sum, int prev_sum) {
        if(node == null){
            return prev_sum == sum;
        }else{
            boolean left = hasPathSumHelper(node.left, sum, prev_sum + node.data );
            boolean right = hasPathSumHelper(node.right, sum, prev_sum + node.data);

            return left || right;
        }
    }


    private static class Node{
        int data;
        Node left;
        Node right;

        private Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        private void insert(int key){
            insertHelper(key, this);
        }

        private Node insertHelper(int key, Node node) {
            if(node == null){
                return new Node(key);
            }else{
                if(key < node.data){
                    node.left = insertHelper(key, node.left);
                }else{
                    node.right = insertHelper(key, node.right);
                }
            }

            return node;
        }
    }
}
