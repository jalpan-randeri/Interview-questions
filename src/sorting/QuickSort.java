package sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by jalpanranderi on 11/14/14.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] data = new int[30];
        Random r= new Random();

        for(int i=0; i<data.length; i++){
            data[i] = r.nextInt() % 30;
        }

        System.out.println(Arrays.toString(data));

        sort(data);

        System.out.println(Arrays.toString(data));
    }



    private static void sort(int[] data){
        quickSort(data, 0, data.length - 1);
    }

    private static void quickSort(int[] data, int low, int high) {
        if(high - low > 0){
            int pivot = partation(data, low, high);
            quickSort(data, low, pivot - 1);
            quickSort(data, pivot + 1, high);
        }
    }


    private static int partation(int[] data, int low, int high){
        int smaller = low;
        int equal = low;
        int large = high;

        int i = data[low + high >> 1];

        while(equal < large){

            if(data[equal] < i){
                // current is less than key
                // swap with equal position
                int temp = data[equal];
                data[equal] = data[smaller];
                data[smaller] = temp;

                smaller++;
                equal++;
            }else if(data[equal] == i){
                equal++;
            }else{
                // greater than key
                int temp = data[equal];
                data[equal] = data[large];
                data[large] = temp;

                large--;
            }
        }


        return equal;
    }

    private static void swap(int[] data, int src, int target) {
       int temp = data[src];
        data[src] = data[target];
        data[target] = temp;
    }

}
