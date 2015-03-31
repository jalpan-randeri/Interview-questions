package tree;

import java.util.Stack;

/**
 * Created by jalpanranderi on 10/25/14.
 */
public class KBalancedBinaryTree {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root = insert(2,root);
        root = insert(3,root);
        root = insert(4,root);

        System.out.println(getHeight(root));
    }


    private static Node kthBalanced(Node root, int k){
        if(root != null){
            int left = getHeight(root.left);
            int right = getHeight(root.right);

            if(left == k && right == k){
                return root;
            }else{

            }
        }

        return null;
    }

    private static int getHeight(Node node){
        int height = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        Node n;
        while(!stack.isEmpty()){
            n = stack.pop();
            height--;
            if(n != null) {
                stack.push(n.right);
                stack.push(n.left);
                height++;
            }
        }

        return height;
    }

    private static Node insert(int data, Node node){
        if(node == null){
            return new Node(data);
        }else{
            if(data < node.data){
                node.left = insert(data, node.left);
            }else{
                node.right =  insert(data, node.right);
            }

            return node;
        }
    }
}
