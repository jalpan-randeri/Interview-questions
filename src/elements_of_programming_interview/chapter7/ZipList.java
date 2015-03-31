package elements_of_programming_interview.chapter7;

/**
 * Created by jalpanranderi on 11/22/14.
 */
public class ZipList {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data +
                    ", " + next;
        }
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);
        n.next.next.next.next = new Node(5);
        n.next.next.next.next.next = new Node(6);

        System.out.println(n);

        System.out.println(new ZipList().zipList(n));
    }


    public Node zipList(Node head){
        Node middle = getMiddle(head);
        Node reverse = reverse(middle);

        head = merge(head, reverse);

        return head;
    }


    private Node getMiddle(Node n){
        Node fast = n;
        Node slow = n;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    private Node reverse(Node head){
        Node prev = null;
        Node next;
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private Node merge(Node first, Node second) {
        Node result = first;
        boolean flag = false;
        first = first.next;
        Node next;

        while (first != null && second != null) {
            if (flag) {
                flag = false;
                next = first.next;

                first.next = null;
                result.next = first;
                result.next = first;

                first = next;
            } else {
                flag = true;
                next = second.next;

                second.next = null;
                result.next = second;
                result = second;

                second = next;

            }

        }


        return result;
    }

}
