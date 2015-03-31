package elements_of_programming_interview.chapter1;

/**
 * Created by jalpanranderi on 11/19/14.
 */
public class Parity {
    public static void main(String[] args) {
        System.out.println(getParity(2));
        System.out.println(getParity(3));
    }



    public static int getParity(int n){
        int parity = 0;
        while(n > 0){
            n = n & (n - 1);
            parity = parity ^ 1;
        }

        return parity;
    }
}
