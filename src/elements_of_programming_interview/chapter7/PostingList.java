package elements_of_programming_interview.chapter7;

/**
 * Created by jalpanranderi on 11/22/14.
 */
public class PostingList {
    private static class Node{
        int data;
        Node next;
        Node post;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
//                    ", post=" + post +
                    '}';
        }


    }


    public static void main(String[] args) {
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);
        n.post = n.next.next;
        n.next.post = n.next.next;
        n.next.next.post = n.next;
        n.next.next.next.post = n.next.next;

        System.out.println(n);

        System.out.println(copy(n));
    }


    public static Node copy(Node posting){

        Node curr = posting;
        Node next;

        // generate new nodes and modify next pointer
        while(curr != null){
            Node temp = new Node(curr.data);

            next = curr.next;

            curr.next = temp;
            temp.next = next;

            curr = next;
        }


        // update the post link
        Node copy = null;
        curr = posting;
        while(curr != null){
            next = curr.next.next;

            copy = curr.next;
            copy.post = curr.post.next;

            curr = next;
        }

        Node head = null;
        curr = posting;
        // reset the next link
        while (curr != null){
            next = curr.next.next;

            if(head == null){
                head = curr.next;
            }
            copy = curr.next;
            curr.next = copy.next;
            copy.next = next;

            curr = next;
        }



        return head;
    }
}
