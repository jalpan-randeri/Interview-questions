package elements_of_programming_interview.chapter6;

import java.util.Arrays;

/**
 * Created by jalpanranderi on 11/19/14.
 */
public class Partition {
    public static void main(String[] args) {
        int[] data = {1, 2, 2, 3, 2, 1, 3, 1, 3};
        partiaton(data, 2);

        System.out.println(Arrays.toString(data));
    }


    public static void partiaton(int[] data, int key){
        int min = 0;
        int equal = 0;
        int max = data.length - 1;

        while(equal < max){
            if(data[equal] == key){
                equal++;
            }else if(data[equal] < key){
                swap(data, equal, min);
                min++;
                equal++;
            }else{
                swap(data, equal, max);
                max--;
            }
        }
    }

    private static void swap(int[] data, int src, int target) {
       int temp = data[src];
        data[src] = data[target];
        data[target] = temp;
    }
}
