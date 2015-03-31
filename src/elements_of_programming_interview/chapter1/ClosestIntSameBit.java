package elements_of_programming_interview.chapter1;

/**
 * Created by jalpanranderi on 11/19/14.
 */
public class ClosestIntSameBit {
    public static void main(String[] args) {
        System.out.println(getNextHigher(3));
        System.out.println(getNextHigher(10));
    }


    private static int getNextHigher(int n){
        for(int i =0; i < 63; i++){
            if(((((n >> i) & 1) ^ ((n >> (i+1)) & 1)) & 1) == 1) {
                n = n ^ ((1 << i) | (1 << (i + 1)));
                return n;
            }
        }

        return 1;
    }
}
