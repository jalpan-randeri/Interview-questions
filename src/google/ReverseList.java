package google;

/**
 * Created by jalpanranderi on 11/12/14.
 */
public class ReverseList{

    public static void main(String[] args) {

        Node head = new Node(1);
        head.insert(2);
        head.insert(3);
//        head.insert(4);
//        head.insert(5);
//        head.insert(6);


        print(head);

//        head = reverse(head);
        head = Reverse(head);

        print(head);

    }



    public static Node reverse(Node node){
        Node n = new Node(-1);
        reverseHelper(node, null, n);
        return n.next;
    }


    public static Node Reverse(Node list){

        if (list == null) {
            return null; // first question
        }

        if (list.next == null){
            return list; // second question
        }

        // third question - in Lisp this is easy, but we don't have cons
        // so we grab the second element (which will be the last after we reverse it)

        Node secondElem = list.next;

        // bug fix - need to unlink list from the rest or you will get a cycle
        list.next = null;

        // then we reverse everything from the second element on
        Node reverseRest = Reverse(secondElem);

        // then we join the two lists
        secondElem.next = list;

        return reverseRest;
    }



    public static Node reverseHelper(Node node, Node prev,  Node last){
        if(node.next == null){
            last.next = node;
            return node;
        }else{
            // switch the link
            Node next = reverseHelper(node.next, node, last);
            next.next = node;

            // remove current next link
            node.next = null;

            return node;
        }

    }



    static int count = 0;

    public static void print(Node n){
        count = 0;
        while(n != null){
            System.out.printf("%2d ",n.data );
            if(count == 4){
                System.out.println("INfinite");
                break;
            }
            count++;
            n = n.next;
        }
        System.out.println();
    }




    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }

        public void insert(int data){
            Node head = this;
            while(head.next != null){
                head = head.next;
            }
            head.next = new Node(data);
        }
    }
}
