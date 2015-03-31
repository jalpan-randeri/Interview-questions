package elements_of_programming_interview.chapter7;

/**
 * Created by jalpanranderi on 11/22/14.
 */
public class StartOfLoop {

    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }


    public static void main(String[] args) {

        Node first = new Node(0);
        first.next = new  Node(1);
        first.next.next = new Node(2);
        first.next.next.next = new Node(3);
        first.next.next.next.next = new Node(4);
        first.next.next.next.next.next = first.next.next;

        Node second = new Node (-1);
        second.next = new Node(-2);

//

        System.out.println(findStartOfLoop(first));
        System.out.println(findStartOfLoop(second));
    }


    public static Node findStartOfLoop(Node head){
        Node slow = head;
        Node fast = head;

        while(slow != null && slow.next != null &&
                fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            // cycle detection
            if(fast == slow){
                slow = head;

                // start of loop detection
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        // no cycle
        return null;
    }


}
