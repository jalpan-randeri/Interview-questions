package topcoder;

/**
 * Created by jalpanranderi on 12/19/14.
 */
public class ForgetfulAddition {
    public static void main(String[] args) {
        String ip = "22";
        minNumber(ip);
    }

    public static int minNumber(String expression){
        int min_sum = Integer.MAX_VALUE;

        for(int i = 1; i < expression.length(); i++){

            int pre = Integer.parseInt(expression.substring(0, i));
            int suffix = Integer.parseInt(expression.substring(i));

            min_sum = Math.min(pre + suffix, min_sum);
        }


        System.out.println(min_sum);
        return min_sum;
    }
}
