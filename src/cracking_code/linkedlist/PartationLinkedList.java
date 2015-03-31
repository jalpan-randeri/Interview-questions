package cracking_code.linkedlist;

/**
 *
 * Created by jalpanranderi on 10/21/14.
 */
public class PartationLinkedList {


    public static class Node{
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }

        public void appendToLast(int data){
            Node last = new Node(data);
            Node n = this;
            while(n.next != null){
                n = n.next;
            }
            n.next = last;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.appendToLast(11);
        head.appendToLast(10);
        head.appendToLast(2);
        head.appendToLast(9);
        head.appendToLast(8);
        head.appendToLast(8);
        head.appendToLast(2);
        head.appendToLast(6);
        head.appendToLast(5);
        head.appendToLast(4);
        head.appendToLast(3);

        print(head);
//
        System.out.println();

        print(partationList(head,3));

    }


    private static Node partationList(Node node, int x){


        Node lowerStart = null;
        Node higherStart = null;

        Node lowerEnd = null;
        Node higherEnd = null;

        while(node != null){
            Node next = node.next;
            node.next = null;

            if(node.data < x) {
               // add it to lower list
               if(lowerStart == null){
                   lowerStart = node;
                   lowerEnd = lowerStart;
               }else{
                   lowerEnd.next = node;
                   lowerEnd = node;
               }
            }else{
               // add it to higher list
               if(higherStart == null){
                   higherStart = node;
                   higherEnd = higherStart;
               }else{
                   higherEnd.next = node;
                   higherEnd = node;
               }
            }

            node = next;
        }


        if(lowerStart == null){
            return higherStart;
        }else{
            lowerEnd.next = higherStart;
        }

        return lowerStart;
    }


    private static void print(Node n){

        while(n != null){
            System.out.print(" "+n+" ");
            n = n.next;
        }
    }
}
