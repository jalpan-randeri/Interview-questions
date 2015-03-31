package arrays;

import java.util.Arrays;
import java.util.HashMap;


/**
 * Created by jalpanranderi on 10/12/14.
 */
public class RemovingDuplicates {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,1,2,3};
        System.out.println(" original array is " + Arrays.toString(data) + " and duplicate removed array is " + Arrays
                .toString(removeDuplicates(data)));


        System.out.println(" original array is " + Arrays.toString(data) + " and duplicate removed array is " + Arrays
                .toString(removeDuplicatesBit(data)));

    }



    // time  -> O(n)
    // space -> O(n)
    private static int[] removeDuplicates(int[] data){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int number : data){
            if(!map.containsKey(number)) {
                map.put(number, number);
            }
        }

        int[] answer = new int[map.size()];
        int count = 0;

        for (Integer integer : map.keySet()) {
            answer[count++] = integer;
        }

        return answer;
    }


    // time  = O(n)
    // space = O(1)
    private static int[] removeDuplicatesBit(int[] data){
        int[] answer = new int[data.length];
        int count = 0;
        int state = 0;

        for(int number : data){
            if((state & (1 << number)) == 0 ) { // shift 1 by given offset and test it
                state = state | 1 << number ;   // preserve the state
                answer[count] = number;
                count++;
            }
        }

        return answer;
    }
}
