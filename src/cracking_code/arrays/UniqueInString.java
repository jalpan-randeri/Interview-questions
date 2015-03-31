package cracking_code.arrays;

/**
 * Implement an algorithm to determine if string contains unique character or not
 *
 * Created by jalpan randeri on 10/21/14.
 */
public class UniqueInString {
    public static void main(String[] args) {
        System.out.printf("%10s contains all unique characters :%5s\n","ab",isContainsAllUnique("ab"));
        System.out.printf("%10s contains all unique characters :%5s\n","a",isContainsAllUnique("a"));
        System.out.printf("%10s contains all unique characters :%5s\n","aA",isContainsAllUnique("aa"));
    }

    // time  = O(n)
    // space = O(1)
    private static boolean isContainsAllUnique(String string){
        int state = 0;

        for(char c : string.toCharArray()){
            if((state & ( 1 << c)) == 0){
                state = state | (1 << c);
            }else{
                return false;
            }
        }

        return true;
    }
}
