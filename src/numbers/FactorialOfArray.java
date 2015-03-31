package numbers;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by jalpanranderi on 10/12/14.
 */
public class FactorialOfArray {
    public static void main(String[] args) {

        int[] data = {1,2,3,4,5};
        System.out.println("Factorial of arrays "+Arrays.toString(data)+" is "+ Arrays.toString(getFactorialOfArrays
                (data)));

        data = new int[]{1,2,3,4,5};
        System.out.println("Factorial of arrays "+Arrays.toString(data)+" is "+ Arrays.toString
                (getFactorialOfArraysImproved(data)));

    }

    private static int[] getFactorialOfArraysImproved(int[] data) {
        HashMap<Integer, Integer> state = new HashMap<>();

        for(int i = 0; i < data.length; i++){
            if(state.containsKey(data[i])){
                data[i] = state.get(data[i]);
            }else {
                int fact = Factorial.getFactorialRecursiveMomnics(data[i]);
                state.put(data[i], fact);
                data[i] = fact;
            }
        }
        return data;
    }

    // time = O(m * n)
    // space = O(n - 1)
    private static int[] getFactorialOfArrays(int[] data){
        for(int i = 0; i < data.length; i++){
            data[i] = Factorial.getFactorialRecursiveMomnics(data[i]); // O(n)
        }
        return data;
    }



}
