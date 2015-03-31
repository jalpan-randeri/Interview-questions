package google;

import java.util.Arrays;

/**
 * Created by jalpanranderi on 11/13/14.
 */
public class MultiplicationOverflow {

    public static void main(String[] args) {
        System.out.println(isOverflow(1,1));
//        Arrays.sort();
    }


    private static boolean isOverflow(int n1, int n2){
        return !((Integer.MAX_VALUE /n1 )> n2);
    }
}
