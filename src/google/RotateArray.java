package google;

import java.util.Arrays;

/**
 * Created by jalpanranderi on 11/21/14.
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7};

        rotate(data, 3);

        System.out.println(Arrays.toString(data));
    }


    public static int[] rotate(int[] data, int k){
        reverse(data, 0, data.length - 1);
        reverse(data, 0, k);
        reverse(data, k + 1, data.length -1);

        return data;
    }


    private static void reverse(int[] data, int start, int end){
        for(int i= start; i < end;  i++){
            swap(data, i, end);
            end--;
        }
    }

    private static void swap(int[] data, int src, int target){
        int temp = data[src];
        data[src] = data[target];
        data[target] = temp;
    }


}
