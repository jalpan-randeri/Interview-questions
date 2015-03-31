package linkedlist;

import java.util.LinkedList;

/**
 * Created by jalpanranderi on 10/20/14.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        n1.key = 1;
        n1.next = n2;
        n2.key = 2;
        n2.next = n3;
        n3.key = 3;


        System.out.println("reverse is "+reverse(n1));
    }


    private static Node reverse(Node head){
        Node next = null;
        Node curr = null;
        while (head != null){
            next = head.next;
            head.next = curr;
            curr = head;

            head = next;
        }

        return curr;
    }


    public static class Node{
        int key;
        Node next;

        @Override
        public String toString() {
            return "{" +
                    "key=" + key +
                    ", next=" + next +
                    '}';
        }
    }
}
