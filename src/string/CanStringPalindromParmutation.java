package string;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given a String,
 * Can a string be permuted into the palindrome string
 *
 * Created by jalpanranderi on 10/19/14.
 */
public class CanStringPalindromParmutation {

    public static void main(String[] args) {
        System.out.printf("does %10s can be permuted to palindrome %5s\n","level",isPermutedToPalindrome("level"));
        System.out.printf("does %10s can be permuted to palindrome %5s\n","levell",isPermutedToPalindrome("levell"));


        System.out.printf("does %10s can be permuted to palindrome %5s\n","level",isPermutedToPalindromeSpaceEfficient("level"));
        System.out.printf("does %10s can be permuted to palindrome %5s\n","levell",
                isPermutedToPalindromeSpaceEfficient("levellz"));


    }


    // time  = O(n)
    // space = O(n)
    private static boolean isPermutedToPalindrome(String s){
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){


            if(map.containsKey(c)){
                // if character is already present
                // hence it appear second time
                // remove it from the map
                map.remove(c);
            }else{
                // character appear first time or odd time so
                // insert into map
                map.put(c,1);
            }
        }

        // for odd length of string map size is 1
        // for even its 0. if valid palindrome
        return map.size() <= 1;
    }


    private static boolean isPermutedToPalindromeSpaceEfficient(String s){
        char[] string = s.toCharArray();
        Arrays.sort(string);  // O(n log n)



        char prev_char = string[0];
        int distance = 1;

        for(int i =1; i < string.length ; i++){
            if(string[i] == prev_char && distance != 0){
                distance --;
            }else{
                prev_char = string[i];
                distance ++;
            }
        }



        return distance <= 1;
    }


//    private static char[] sort(String string) {
//        return mergeSort(string.toCharArray());
//    }

//    // merge sort
//    private static char[] mergeSort(char[] chars){
//
//
//        char[] left = null;
//        char[] right = null;
//
//        int mid =  chars.length >> 1;
//
//        if(chars.length > 1) {
//
//            System.out.printf("%2d\n",mid);
//
//            left = mergeSort(Arrays.copyOfRange(chars, 0, mid));
//            right = mergeSort(Arrays.copyOfRange(chars, mid+1, chars.length));
//
//            return merge(left, right);
//        }
//
//        return chars;
//
//    }
//
//
//    private static char[] ans;
//
//    private static char[] merge(char[] left, char[] right) {
//
//        ans = new char[left.length + right.length];
//        int i=0, j = 0, k = 0;
//
//        for(; i < left.length && j < right.length; k++){
//            if(left[i] < right[j]){
//                ans[k] = left[i];
//                i++;
//            }else{
//                ans[k] = right[j];
//                j++;
//            }
//        }
//
//        if(i != left.length){
//            copyArray(left, i, k);
//        }
//
//        if(j != right.length){
//            copyArray(right, j, k);
//        }
//
//
//        return ans;
//    }
//
//    private static void copyArray(char[] remainingArray, int remainingPtr, int ansPtr) {
//        for (; ansPtr < ans.length; ansPtr++, remainingPtr++) {
//            ans[ansPtr] = remainingArray[remainingPtr];
//        }
//
//    }
}
