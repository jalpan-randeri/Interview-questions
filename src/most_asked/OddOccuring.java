package most_asked;

/**
 * Created by jalpanranderi on 11/6/14.
 */
public class OddOccuring {
    public static void main(String[] args) {
        int[] data = {1,1,2,3,2,1,3,1,2};
        System.out.println(oddOccuring(data));
    }

    // time  = O(n)
    // space = O(1)
    private static int oddOccuring(int[] data){
        int ans = 0;
        for(int d : data){
            ans ^= d;
        }

        return ans;
    }
}
