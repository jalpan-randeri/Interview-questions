package cracking_code.linkedlist;

/**
 * Created by jalpanranderi on 10/21/14.
 */
public class LinkedListImpl {

    public class Node{
        Node next = null;
        int key;


        public Node(int data){
            key = data;
        }

        void appendToTail(int data){

            Node end = new Node(data);
            Node curr = this;

            while(curr.next != null){
                curr = curr.next;
            }

            curr.next = end;
        }
    }
}
