package most_asked;

/**
 *
 * Given a linkedlist of integers and an integer value, delete every node of the linkedlist containing that value.
 * - See more at: http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.BgLHYvZ6.dpuf
 *
 * Created by jalpanranderi on 11/5/14.
 */
public class RemoveNode {


    public static void main(String[] args) {
        Node head = new Node(1);
        head.insert(1);
        head.insert(2);
        head.insert(3);
        head.insert(4);
        head.insert(1);

        print(head);

        removeNode(head, 1);
        print(head);
    }

    private static void removeNode(Node node, int key){

        Node prev = node;

        while(node != null){

            if(node.data == key){
                Node next = node.next;

                if(next != null) {
                    node.next = next.next;
                    node.data = next.data;
                }else{
                    prev.next = null;
                    node = null;
                }
            }else{
                prev = node;
                node = node.next;
            }
        }
    }



    private static void print(Node n){
        while(n != null){
            System.out.printf("%2d ", n.data);
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

        public void insert(int key){
            Node n = this;
            while(n.next != null){
                n = n.next;
            }
            n.next = new Node(key);
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }
}
