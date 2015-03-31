package cracking_code.linkedlist;

import java.util.Stack;

/**
 * Created by jalpanranderi on 10/21/14.
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(2);
        head.appendToTail(1);

        print(head);

        System.out.println("does list is palindrome "+isPalindrome(head));

    }


    public static class Node{
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }

        public void appendToTail(int data){
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

    private static void print(Node node){
        System.out.println();
        while(node != null){
            System.out.print(" "+node+" ");
            node = node.next;
        }
        System.out.println();
    }

    private static boolean isPalindrome(Node list){
        Stack<Integer>  stack = new Stack<>();

        Node slow = list;
        Node fast = list;

        while(fast != null && fast.next != null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // odd length
        if(fast != null){
            slow = slow.next;
        }

        while(slow != null){
            int top = stack.pop();

            if(top != slow.data){
                return false;
            }else{
                slow = slow.next;
            }
        }

        return true;
    }
}
