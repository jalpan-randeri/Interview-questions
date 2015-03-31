package google;

/**
 *
 * Given an interger reverse it bits
 *
 * Created by jalpanranderi on 11/12/14.
 */
public class ReverseBitOfInteger {
    public static void main(String[] args) {

        System.out.println(" reverseBit is "+reverseBits(1));
        System.out.println(" reverseBit is "+reverseBits(2));
        System.out.println(" reverseBit is "+reverseBits(3));
        System.out.println(" reverseBit is "+reverseBits(4));
    }


    private static int reverseBits(int no){


        int ans = 0;
        while(no > 0){
            ans = ans << 1;
            int unit = no & 1;
            ans = ans | unit;
            no = no >> 1;
        }

        return ans;
    }
}
