package epi.chapter11;

import java.util.Random;

/**
 * Created by jalpanranderi on 11/26/14.
 */
public class KthElement {
    public static void main(String[] args) {
        int[] data = {1201,123,12,12,11212,2121,1,2,3,4,5,6,7,8,9,10};
        System.out.println(getKthElement(data, 4));
    }


    public static int getKthElement(int[] data, int k){

        int start = 0;
        int end = data.length - 1;


        while(start <= end){

            int p = partation(data, start, end);
            if(p == k - 1){
                return data[p];
            }else if ( k - 1 > p ){
                // required is in right halve
                start = p + 1;
            }else{
                // required is in left halve
                end = p;
            }

        }

        return -1;
    }

    private static int partation(int[] data, int start, int end){
        int equal = start;
        int pivot = data[start + end >> 1];
        while(start < end){
            if(pivot == data[equal]){
                equal++;
            }else if( pivot > data[equal]){
                swap(data, equal, start);
                equal++;
                start++;
            }else{
                swap(data, equal, end);
                end--;
            }
        }
        return equal - 1;
    }

    private static void swap(int[] data, int src, int tar){
        int temp = data[src];
        data[src] = data[tar];
        data[tar]  =  temp;
    }
}
