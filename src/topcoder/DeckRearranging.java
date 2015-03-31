package topcoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jalpanranderi on 11/14/14.
 */
public class DeckRearranging{

    public static void main(String[] args) {
        String deck = "BRBRR";

        int[] above = {0, 0, 1, 0, 3};


        deck = "RBRRBRBB";
        above = new int[]{0,1,0,0,4,0,6,7};

        System.out.println(rearrange(deck,above));



    }


    public static String rearrange(String deck, int[] above){

        ArrayList<Character> ans = new ArrayList<>();
        for(int i=0; i<deck.length(); i++){
            char c = deck.charAt(i);
            ans.add(above[i],c);
        }

        StringBuilder builder = new StringBuilder();
        for(char c:ans){
            builder.append(c);
        }

        return builder.toString();
    }

//    private static String generateString(Node n){
//        StringBuilder builder = new StringBuilder();
//        while(n != null){
//            builder.append(n.data);
//            n = n.next;
//        }
//
//        return builder.toString();
//    }
//
//
//    private static Node insertChar(char c, int position, Node head){
//        int count = 0;
//        Node n = head;
//
//
//        if(count == position){
//            Node n1 = new Node(head.data);
//            n1.next = head.next;
//            head.data = c;
//            head.next = n1;
//            return head;
//        }
//
//
//
//        while(n.next != null){
//            if(count == position){
//                Node newNode = new Node(n.data);
//                newNode.next = n.next;
//                n.data = c;
//                n.next = newNode;
//                break;
//            }else{
//                n = n.next;
//                count++;
//            }
//
//        }
//
//        if(count != position){
//            n.next = new Node(c);
//        }
//
//        return head;
//    }
//
//
//
//    public static class Node{
//        char data;
//        Node next;
//
//        public Node(char c){
//            data = c;
//        }
//
//        @Override
//        public String toString() {
//            return "Node{" +
//                    "data=" + data +
//                    ", next=" + next +
//                    '}';
//        }
//    }

}