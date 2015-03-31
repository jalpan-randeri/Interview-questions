package elements_of_programming_interview.chapter7;

/**
 * Created by jalpanranderi on 11/22/14.
 */
public class DeleteAndReverse {

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
            Node head = new Node(0);
            head.next = new Node(1);
            head.next.next = new Node(2);
            head.next.next.next = new Node(3);
            Node deleted = new Node(3);
            head.next.next.next.next = deleted;
            head.next.next.next.next.next = new Node(4);

            System.out.println(head);

            delete(deleted);

            System.out.println(head);

            System.out.println(reverse(head));

        }

        //Delete From single list

        public static void delete(Node n) {
            n.data = n.next.data;
            n.next = n.next.next;
        }


        // Reverse a list

        public static  Node reverse(Node head) {
            Node prev = null;
            Node next;

            while (head != null) {
                next = head.next;

                head.next = prev;
                prev = head;

                head = next;
            }

            return prev;
        }

    }
