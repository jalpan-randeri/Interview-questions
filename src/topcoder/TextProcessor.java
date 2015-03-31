package topcoder;

/**
 * Created by jalpanranderi on 10/25/14.
 */
public class TextProcessor {
    public static void main(String[] args) {
        System.out.println(collectLetters("dcba"));
    }

    public static String collectLetters(String ip) {
        StringBuilder builder = new StringBuilder(ip.length());

        if (ip.length() > 0) {
            Node root = new Node(ip.charAt(0));

            for (int i = 1; i < ip.length(); i++) {         // O(n)
                root = insert(ip.charAt(i), root);          // log(n)
            }

            print(root, builder);                           // O(n)
        }

        return builder.toString();
    }

    private static void print(Node n, StringBuilder builder) {
        if (n != null) {
            print(n.left, builder);
            builder.append(n.key);
            print(n.right, builder);
        }
    }

    private static Node insert(char key, Node head) {
        if (head == null) {
            return new Node(key);
        } else {
            if (key < head.key) {
                head.left = insert(key, head.left);
            } else {
                head.right = insert(key, head.right);
            }

            return head;
        }
    }

    public static class Node {
        Node right;
        Node left;
        char key;

        public Node(char key) {
            this.key = key;
        }
    }
}
