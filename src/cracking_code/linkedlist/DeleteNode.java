package cracking_code.linkedlist;

/**
 * Created by jalpanranderi on 10/21/14.
 */
public class DeleteNode {

    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node appendLast(int data){
            Node n = new Node(data);
            Node head = this;
            while(head.next != null){
                head = head.next;
            }
            head.next = n;
            return n;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.appendLast(3);
        head.appendLast(4);
       Node n= head.appendLast(5);
        head.appendLast(6);
        head.appendLast(7);

        print(head);
        deleteNode(n);
        System.out.println();
        print(head);
    }


    private static void print(Node head){
        while(head != null){
            System.out.print(head);
            head = head.next;
        }
    }


    private static void deleteNode(Node n){
        if(n.next == null){
            throw new RuntimeException("Can not delete last node");
        }else{
            n.data = n.next.data;
            n.next = n.next.next;
        }
    }

}
