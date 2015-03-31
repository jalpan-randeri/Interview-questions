package most_asked;

import java.util.Random;

/**
 * Created by jalpanranderi on 11/8/14.
 */
public class ReverseLinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public void insert(int key){
            Node n = this;
            while(n.next != null){
                n= n.next;
            }
            n.next = new Node(key);
        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.insert(2);
        head.insert(3);
        head.insert(4);
        head.insert(5);
        head.insert(6);


//        Random r = new Random();
//        r.nextInt();


        print(head);

        head = reverse(head);

        print(head);
    }


    private static Node reverse(Node n){
        Node next;
        Node prev = null;
        while(n != null){
            next = n.next;

            n.next = prev;
            prev = n;

            n = next;
        }

        return prev;
    }



    private static void print(Node n){
        while(n != null){
            System.out.printf("%2d", n.data);
            n = n.next;
        }
        System.out.println();
    }

}
