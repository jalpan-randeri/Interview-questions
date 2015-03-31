package google;

/**
 * Created by jalpanranderi on 11/21/14.
 */
public class ReverseLinkedList {


    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        System.out.println(head);

        head = reverse(head);

        System.out.println(head);
    }

    public static Node reverse(Node n){
        Node prev = null;
        Node next;

        while(n  != null){
            next = n.next;
            // switch the link
            n.next = prev;
            prev = n;
            n = next;
        }
        return prev;
    }


}
