package elements_of_programming_interview.chapter6;

/**
 * Created by jalpanranderi on 11/22/14.
 */
public class ReverseWordInString {
    public static void main(String[] args) {
        String str = "Hi i am jalpan";

        System.out.println(reverse(str));
    }


    public static String reverse(String str){
        char[] c = str.toCharArray();

        reverse(c, 0, c.length - 1);

        int start = 0;
        for(int i = 0; i < c.length; i++){
            if(c[i] == ' '){
                reverse(c, start, i - 1);
                start = i + 1;
            }
        }

        reverse(c, start, c.length - 1);

        return String.valueOf(c);
    }

    private static void reverse(char[] str, int start, int end){
        for(int i = start; i < end; i++){
            swap(str, i, end);
            end--;
        }
    }

    private static void swap(char[] str, int src, int target){
        char temp = str[src];
        str[src] = str[target];
        str[target] = temp;
    }


}
