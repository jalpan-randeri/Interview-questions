package careercup;

/**
 * Created by jalpanranderi on 10/31/14.
 */
public class ReverseSinglyLinkedList {

    public static class LinkedListNode{
        int data;
        LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
        }

        public void insert(int d){
            LinkedListNode n = this;
            while(n.next != null){
                n = n.next;
            }
            n.next = new LinkedListNode(d);
        }
    }


    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.insert(2);
        head.insert(3);
        head.insert(4);

        print(head);

       head =  reverseList(head);

        print(head);
    }


    private static void print(LinkedListNode node){
        System.out.println();
        while (node != null){
            System.out.printf("%2d ",node.data);
            node = node.next;
        }

    }

    private static LinkedListNode reverseList(LinkedListNode node){

        LinkedListNode prev = null;
        while(node != null){
            // save next node
            LinkedListNode next = node.next;

            // swap prev node to next node
            node.next = prev;

            // update prev to current
            prev = node;

            // rest node to next node
            node = next;
        }

        return prev;
    }
}
