package cracking_code.linkedlist;

/**
 * Created by jalpanranderi on 10/21/14.
 */
public class KthToLast {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }

        public void appendLast(int data){
            Node last = new Node(data);
            Node n = this;

            while(n.next != null){
                n = n.next;
            }
            n.next = last;
        }

        @Override
        public String toString() {
            return  String.valueOf(data);
        }
    }

    private static void print(Node n){
        while(n != null){
            System.out.print(" "+n.data+" ");
            n = n.next;
        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.appendLast(2);
        head.appendLast(3);
        head.appendLast(4);
        head.appendLast(5);
        head.appendLast(6);
        head.appendLast(7);
        head.appendLast(8);

        print(head);
        System.out.println("\nkth to last is "+kThToLast(head, 3));
        System.out.println("kth to last is "+kThToLast(head, 8));
        System.out.println("kth to last is "+kThToLast(head, 10));
    }

    // time  = O(n)
    // space = O(1)
    private static Node kThToLast(Node node,int k){
        Node answer = node;
        for(int i=0; i < k; i++ ){
            if(node != null){
                node = node.next;
            }else{
                return null;
            }
        }

        while(node != null){
            node = node.next;
            answer = answer.next;
        }

        return answer;
    }


}
