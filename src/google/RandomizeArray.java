package google;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by jalpanranderi on 11/20/14.
 */
public class RandomizeArray {

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5};
        System.out.println(Arrays.toString(randomize(data)));
    }


    public static int[] randomize(int[] data){
        Random r = new Random();

        for(int i = data.length - 1; i > 0; i--){
            int swap_position = r.nextInt() % i + 1;
            System.out.println(swap_position);

            swap(data, i, swap_position);
        }

        return data;
    }


    private static void swap(int[] data, int src, int target){
        int temp = data[src];
        data[src] = data[target];
        data[target] = temp;
    }

}
