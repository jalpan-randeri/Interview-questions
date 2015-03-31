package amazon;



/**
 * Created by jalpanranderi on 12/22/14.
 */
public class GrayCode {
    public static void main(String[] args) {
        isGrayCodeNeighbour((byte) 0,(byte) 1);
        isGrayCodeNeighbour((byte) 5,(byte) 1);

    }



    /// Wrong Implementation  reason 1st is valid and 2nd ip is wrong
    private static boolean isGrayCodeNeighbour(byte no1, byte no2){
        int temp1 = (no1 ^ (no1 >> 1));
        int temp2 = (no2 ^ (no2 >> 1));

        System.out.println(temp1);
        System.out.println(temp2);


       boolean ans = (temp1 ^ no2) == 0 || (temp2 ^ no1) == 0;
        System.out.println(ans);


        int state = no1 ^ no2;
        state = state & (state - 1);
        ans = state == 0;

        System.out.println(ans);
        return ans;
    }
}
