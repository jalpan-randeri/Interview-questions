package tree;

/**
 * Created by jalpanranderi on 11/6/14.
 */
public class NumberOfNodeInTree {

    public static void main(String[] args) {
        Node root = new Node(2);
        root.insert(1);
        root.insert(4);
        root.insert(3);
        root.insert(-3);
        root.insert(100);

        System.out.println(root);

        System.out.println("total nodes "+getTotalNumberOfNodes(root));
        System.out.println("Maximum Depth "+maxDepth(root));
        System.out.println("Maximum Value "+maxValue(root));
        System.out.println("Inorder Tree");
        printInorder(root);
        System.out.println();
        System.out.println("Postorder Tree");
        printPostorder(root);
        System.out.println();
    }


    private static int getTotalNumberOfNodes(Node root){
        return totalNodesHelper(root, 0);
    }

    private static int totalNodesHelper(Node node, int count) {
        if(node == null) {
            return 0;
        }

        int left = totalNodesHelper(node.left, count);
        int right = totalNodesHelper(node.right, count);

        return left+right+1;
    }

    private static int maxDepth(Node node){
        return maxDepthHelper(node, 0);
    }

    private static int maxDepthHelper(Node node, int count) {
        if(node == null) {
            return 0;
        }

        int left = maxDepthHelper(node.left, count);
        int right = maxDepthHelper(node.right, count);

        return Math.max(left, right)+1;
    }


    private static int maxValue(Node node){
        return maxValueHelper(node, Integer.MIN_VALUE);
    }

    private static int maxValueHelper(Node node, int max) {
        if(node == null){
            return max;
        }else{
            return maxValueHelper(node.right, Math.max(max, node.data));
        }
    }



    private static void printInorder(Node node){
        if(node != null){
            printInorder(node.left);
            System.out.printf("%4d",node.data);
            printInorder(node.right);
        }
    }

    private static void printPostorder(Node node){
        if(node != null){
            printPostorder(node.left);
            printPostorder(node.right);
            System.out.printf("%5d",node.data);
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

        private Node insertHelper(int key, Node node) {
            if(node == null){
                return new Node(key);
            }else if(node.data > key){
                node.left = insertHelper(key, node.left);
            }else{
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
