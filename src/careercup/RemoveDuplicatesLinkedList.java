package careercup;

/**
 * Created by jalpanranderi on 10/31/14.
 */
public class RemoveDuplicatesLinkedList {

    public static class LinkedListNode{
        LinkedListNode next;
        int data;

        public LinkedListNode(int data) {
            this.data = data;
        }

        public void insert(int d){
            LinkedListNode n = this;
            while(n.next != null){
                n = n.next;
            }
            n.next = new LinkedListNode(d);
        }

        public void print(){
            System.out.println();
            LinkedListNode n = this;
            while(n != null){
                System.out.printf("%2d ",n.data);
                n = n.next;
            }
        }
    }


    public static void main(String[] args) {
        LinkedListNode node = new LinkedListNode(1);
//        node.insert(2);
//        node.insert(2);
//        node.insert(2);
//        node.insert(2);
//        node.insert(3);
        node.print();


        node = removeDuplicates(node);
        node.print();
    }


    public static LinkedListNode removeDuplicates(LinkedListNode head){
        LinkedListNode node = head.next;
        LinkedListNode prev = head;

        while(node != null){

            if(node.data == prev.data){
                prev.next = node.next;
            }else{
                prev = node;
            }
            node = node.next;

        }

        return head;
    }

}
