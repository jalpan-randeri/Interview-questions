package linkedlist;

/**
 * Created by jalpanranderi on 10/15/14.
 */
public class MergeSortedList {
    public static void main(String[] args) {

    }


    private static Node merge(Node list1, Node list2){
        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        Node head = list1.data < list2.data ? list1 : list2;

        while(list1.next != null && list2.next != null){
            if(list1.data < list2.data){
//                temp = list1;

            }
        }

        return head;

    }



    private class Node{
        int data;
        Node next;
    }
}
