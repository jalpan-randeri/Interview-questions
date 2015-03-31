package cracking_code.algo;

import java.util.Arrays;

/**
 * Created by jalpanranderi on 10/21/14.
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] data1 = {1,2,3};
//        int[] data2 = {4,5,6};
//
//        System.out.println(" result data is "+Arrays.toString(sort(data1, data2)));



        System.out.println(" result data is "+Arrays.toString(margeSort(data)));
    }



    private static int[] data = {5,1,2};

    private static int[] margeSort(int[] data){
        System.out.println(Arrays.toString(data));
        int mid = data.length >> 1;
        if(data.length >= 2) {
            int[] left = margeSort(Arrays.copyOfRange(data, 0, mid));
            int[] right = margeSort(Arrays.copyOfRange(data, mid, data.length));
            data = merge(left, right);
        }
    return data;
    }

    private static int[] merge(int[] left, int[] righ) {
        int[] answer = new int[left.length + righ.length];
        int i=0, j=0, k = 0;

        for(; i < left.length && j < righ.length; k++){
            if(left[i] < righ[j]){
                answer[k] = left[i];
                i++;
            }else{
                answer[k] = righ[j];
                j++;
            }
        }

        if(i != left.length){
            answer = appendData(answer, left, i, k);
        }

        if(j != righ.length){
            answer = appendData(answer, righ, j, k);
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    private static int[] appendData(int[] answer, int[] data, int j, int k) {
        for(;j < data.length; j++, k++){
            answer[k] = data[j];
        }
        return answer;
    }
}
