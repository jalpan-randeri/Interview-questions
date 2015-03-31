package elements_of_programming_interview.chapter7;

/**
 * Created by jalpanranderi on 11/22/14.
 */
public class StartOfMerge {

    private static  class Node{
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
        Node first = new Node(0);
        first.next = new  Node(1);
        first.next.next = new Node(2);
        first.next.next.next = new Node(3);
        first.next.next.next.next = new Node(4);

        Node second = new Node (-1);
        second.next = new Node(-2);
        second.next.next = first.next.next.next;

        System.out.println(getStartOfOverlappingList(first,second));

    }

    public static Node getStartOfOverlappingList(Node first, Node second){
        int firstLength = getLength(first);
        int secondLength = getLength(second);

        int diff = Math.abs(firstLength - secondLength);

        if(firstLength > secondLength){
            first = moveSteps(first, diff);
        }else{
            second = moveSteps(second, diff);
        }

        while(first != second){
            first = first.next;
            second = second.next;
        }

        return first;
    }


    private static int getLength(Node n){
        int count = 0;
        while(n != null){
            count++;
            n = n.next;
        }
        return count;
    }


    private static Node moveSteps(Node n, int step){
        while(step > 0 && n != null){
            step--;
            n = n.next;
        }
        return n;
    }

}
