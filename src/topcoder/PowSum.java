package topcoder;

/**
 * Created by jalpanranderi on 10/29/14.
 */
public class PowSum {

    public static void main(String[] args) {
        new PowSum().getSum(-12, 12, 9);
    }

    public int getSum(int low, int high, int pow){
        int sum = 0;


        for(int i = 1; i <= pow; i++){
            for(int j=low; j<= high; j++ ){

                if (j == 0){
                    continue;
                }

                sum += Math.round(Math.pow(j,i));
            }
            System.out.println();
        }
        return sum;
    }
}
