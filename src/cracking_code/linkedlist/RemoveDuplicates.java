package cracking_code.linkedlist;

import linkedlist.ReverseLinkedList;

import java.util.HashMap;

/**
 * Created by jalpanranderi on 10/21/14.
 */
public class RemoveDuplicates {


    public static class Node{
        int data;
        Node next = null;

        public Node(int value){
            data = value;
        }


    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);

        Node head1 = new Node(1);


        removeDuplicates(head);
        print(head);

        System.out.println();
        removeDuplicates(head1);
        print(head1);


        Node head2 = new Node(1);
        head2.next = new Node(1);
        head2.next.next = new Node(1);
        head2.next.next.next = new Node(1);

        System.out.println();
        removeDuplicates(head2);
        print(head2);

    }

    private static void print(Node head) {


        while (head != null){
            System.out.print(" "+head.data+" ");
            head = head.next;
        }


    }


    // time  = O(n)
    // space = O(m)  where m is distinct nodes

    private static void removeDuplicates(Node n){
        HashMap<Integer, Integer> state = new HashMap<>();

        Node prev = null;
        while(n != null){
            if(state.containsKey(n.data)){
                prev.next = n.next;
            }else{
                prev = n;
                state.put(n.data, n.data);
            }
            n = n.next;
        }
    }
}
