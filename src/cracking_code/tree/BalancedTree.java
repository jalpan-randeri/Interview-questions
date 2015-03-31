package cracking_code.tree;

/**
 * Created by jalpanranderi on 10/21/14.
 */
public class BalancedTree {

    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);


        System.out.println("does this balanced "+isBalanced(root));
    }


    private static boolean isBalanced(TreeNode root){
        return getHeight(root) != -1;
    }

    private static int getHeight(TreeNode node) {
        if(node == null){
            return 0;
        }

        int leftHeight = getHeight(node.left);
        if(leftHeight == -1){
            return -1;
        }

        int rightHeight = getHeight(node.right);
        if(rightHeight == -1){
            return -1;
        }

        int diff = leftHeight - rightHeight;
        if(Math.abs(diff) > 1){
            return -1;
        }else{
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
