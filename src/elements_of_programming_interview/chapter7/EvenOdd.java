package elements_of_programming_interview.chapter7;

/**
 * Created by jalpanranderi on 11/22/14.
 */
public class EvenOdd {
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
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
//        head.next.next.next.next.next = new Node(5);

        System.out.println(head);

        System.out.println(evenOddList(head));

    }


    public static Node evenOddList(Node head){
        Node evenHead = null;
        Node evenTail = null;
        Node oddHead = null;
        Node oddTail = null;

        boolean flag = true;
        Node next = null;

        while(head != null){
            next = head.next;
            head.next = null;

            if(flag){
                flag = false;
                if(evenHead == null){
                    evenHead = head;
                    evenTail = head;
                }else{
                    evenTail = appendToTail(evenTail, head);
                }
            }else{
                flag = true;

                if(oddHead == null){
                    oddHead = head;
                    oddTail = head;
                }else{
                    oddTail = appendToTail(oddTail, head);
                }
            }

            head = next;

        }

        System.out.println(evenHead);
        System.out.println(oddHead);

        evenTail.next = oddHead;

        return evenHead;

    }


    private static Node appendToTail(Node tail, Node n){
        tail.next = n;
        tail = n;
        return tail;
    }

}

