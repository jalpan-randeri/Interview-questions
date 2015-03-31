package elements_of_programming_interview.chapter7;

/**
 * Created by jalpanranderi on 11/22/14.
 */
public class MergeSotedList {
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
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(4);
        first.next.next.next = new Node(6);

        Node second = new Node(0);
        second.next = new Node(1);
        second.next.next = new Node(3);
        second.next.next = new Node(5);

        Node result = mergeList(first, second);

        System.out.println(result);

    }


    private static void appendNode(Node head, Node tail, Node n){
        if(head == null){
            head = n;
        }else{
            tail.next = n;
        }



    }




    public static Node mergeList(Node first, Node second){

        Node sortedHead = null;
        Node sortedTail = null;

        while(first != null && second != null){
            if(first.data < second.data){
                if(sortedHead == null){
                    sortedHead = first;
                    sortedTail = first;
                }else{
                    sortedTail.next = first;
                    sortedTail = first;
                }
                first = first.next;
            }else{
                if(sortedHead == null){
                    sortedHead = second;
                    sortedTail = second;
                }else{
                    sortedTail.next = second;
                    sortedTail = second;
                }
                second = second.next;
            }
        }

        if(first != null){
            if(sortedHead == null){
                sortedHead = first;
            }else {
                sortedTail.next = first;
            }
        }

        if(second != null){
            if(sortedHead == null){
                sortedHead = second;
            }else {
                sortedTail.next = second;
            }
        }

        return sortedHead;
    }



}
