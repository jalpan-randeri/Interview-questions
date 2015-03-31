package epi.chapter11;

/**
 * Created by jalpanranderi on 11/26/14.
 */
public class FindMissing {
    public static void main(String[] args) {
        int[] data = {1,1,1,2,2,2,3,3,3,4};
        System.out.println(getMissing(data));
    }

    private static int getMissing(int[] data){
        int one = 0, two = 0;
        int next_one, next_two;

        for(int d: data){
            next_one = (~d & one) | (d & ~one & ~two);
            next_two = (~d & two) | (d & one);
            one = next_one;
            two = next_two;
        }

        return one;
    }
}
