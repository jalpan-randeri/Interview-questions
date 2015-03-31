package sorting;

import java.util.Arrays;

/**
 * Created by jalpanranderi on 11/12/14.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] data = {4,2,5,6,1,2,6,9,0, -1};
        System.out.println(Arrays.toString(insertionSort(data)));
    }



    private static int[] insertionSort(int[] data){
        for(int i = 0; i < data.length; i++){
            for(int j=i; j>0 && data[j] < data[j - 1]; j--){
                int temp = data[j - 1];
                data[j - 1] = data[j];
                data[j] = temp;
            }
        }

        return data;
    }

}
