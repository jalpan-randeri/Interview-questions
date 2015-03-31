package numbers;

import java.util.HashMap;

/**
 * Created by jalpanranderi on 10/12/14.
 */
public class Factorial {
    public static void main(String[] args) {

        System.out.printf("Factorial of %3d is %6d\n",1,getFactorialRecursive(1));
        System.out.printf("Factorial of %3d is %6d\n",2,getFactorialRecursive(2));
        System.out.printf("Factorial of %3d is %6d\n",5,getFactorialRecursive(5));
        System.out.printf("Factorial of %3d is %6d\n",16,getFactorialRecursive(16));



        System.out.printf("Factorial of %3d is %6d\n",1,getFactorialRecursiveMomnics(1));
        System.out.printf("Factorial of %3d is %6d\n",2,getFactorialRecursiveMomnics(2));
        System.out.printf("Factorial of %3d is %6d\n",5,getFactorialRecursiveMomnics(5));
        System.out.printf("Factorial of %3d is %6d\n",16,getFactorialRecursiveMomnics(16));

    }

    // time  = O(n)
    // space = O(n - 1)
    private static int getFactorialRecursive(int number){
        if(number <= 1){
            return 1;
        }else{
            return number * getFactorialRecursive(number - 1);
        }
    }


    public static HashMap<Integer, Integer> state = new HashMap<>();
    static {
        state.put(4, 24);
        state.put(8, 40320);
        state.put(12, 479001600);
        state.put(16, 2004189184);
    }

    public static int getFactorialRecursiveMomnics(int number){
        if(number <= 1){
            return 1;
        }else if(state.containsKey(number)){
            return state.get(number);
        }else{
            return number * getFactorialRecursiveMomnics(number - 1);
        }
    }





}
