package elements_of_programming_interview.chapter7;

/**
 * Created by jalpanranderi on 11/22/14.
 */
public class Palindrom {

    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return  data +
                    ", " + next;
        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);


        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(2);
        n.next.next.next = new Node(1);


        Node seocnd = new Node(1);
        seocnd.next = new Node(2);
        seocnd.next.next = new Node(2);


        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome(n));
        System.out.println(isPalindrome(seocnd));
    }


    public static boolean isPalindrome(Node head){
        Node middle = getMiddleElement(head);

        Node reverse = reverse(middle);

        while(reverse != null){
            if(reverse.data != head.data){
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }

        return true;
    }


    private static Node getMiddleElement(Node n){
        Node slow = n;
        Node fast = n;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node reverse(Node n){
        Node prev = null;
        while(n != null){
            Node next = n.next;
            n.next = prev;
            prev = n;
            n = next;
        }
        return prev;
    }
}
