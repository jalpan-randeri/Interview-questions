package most_asked;

/**
 *
 * We are given 3 strings: str1, str2, and str3. Str3 is said to be a shuffle of str1 and str2 if it can be formed by
 * interleaving the characters of str1 and str2 in a way that maintains the left to right ordering of the characters
 * from each string. For example, given str1=”abc” and str2=”def”, str3=”dabecf” is a valid shuffle since it
 * preserves the character ordering of the two strings. So, given these 3 strings write a function that detects
 * whether str3 is a valid shuffle of str1 and str2.
 * - See more at: http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.BgLHYvZ6.dpuf
 *
 * Created by jalpanranderi on 11/5/14.
 */
public class CombineTwoStrings {

    public static void main(String[] args) {
        System.out.println(isSuffle("abc", "def", "dabecf"));

        System.out.println(isSuffle("abc", "def", "dabecfz"));

        System.out.println(isSuffle("abc", "def", "dacbe"));
    }


    private static boolean isSuffle(String a, String b, String s){
        int ptr_a = 0;
        int ptr_b = 0;
        int ptr_s = 0;

        for(;ptr_s < s.length(); ){
            char c = s.charAt(ptr_s);

            if(ptr_a < a.length() && c == a.charAt(ptr_a)){
                ptr_a++;
                ptr_s++;
            }else if(ptr_b < b.length() && c == b.charAt(ptr_b)){
                ptr_b++;
                ptr_s++;
            }else{
                return false;
            }
        }

        return true;
    }

}
