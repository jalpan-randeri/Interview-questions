package recursion;

import java.util.HashMap;

/**
 * Created by jalpanranderi on 11/14/14.
 */
public class Fibonacci {

    public static void main(String[] args) {

        fibo(6);

        fibonacci(6);




    }



    private static void fibo(int i){
        int a = 0;
        int b = 1;
        int c = 0;
        for(int n = 0; n <= i; n++){
            c = a + b;
            a = b;
            b = c;
            System.out.printf("%3d",a);
        }
        System.out.println();
    }


    private static void fibonacci(int i){
        fibonacciHelper(i, new HashMap());
    }

    private static int fibonacciHelper(int i, HashMap<Integer, Integer> state){

        if(i <= 1){
            if(state.containsKey(i)){
                return state.get(i);
            }else {
                state.put(i, 1);
                System.out.printf("%3d", 1);
            }
            return 1;
        }

        int a,b,c;

        if(state.containsKey(i - 1)){
            a = state.get(i - 1);
        }else{
            a = fibonacciHelper(i - 1, state);
        }

        if(state.containsKey(i - 2)){
            b = state.get(i - 2);
        }else {
            b = fibonacciHelper(i - 2, state);
        }


        c = a + b;
        state.put(i, c);
        System.out.printf("%3d",c);

        return c;
    }
}
