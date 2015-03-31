package topcoder;

/**
 * Created by jalpanranderi on 11/8/14.
 */
public class JoshSum{

    public static void main(String[] args) {
        new JoshSum().getJoshSum(5);
        new JoshSum().getJoshSum(10);
        new JoshSum().getJoshSum(20);

        new JoshSum().getJoshSum(44);
        new JoshSum().getJoshSum(98765);
    }

    public int getJoshSum(int n){
        int a = 1;
        int b = 1;
        int temp;
        int sum = 2;
        for(int i = 2; i < n; i++){
            temp = b;
            b = a + b;
            a = temp;

            if(b >= 10) {
               b = b - 10;
            }

            sum = sum + b;
        }

        return sum;
    }


}