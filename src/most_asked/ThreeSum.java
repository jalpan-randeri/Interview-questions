package most_asked;

import java.util.Arrays;

/**
 * Created by jalpanranderi on 11/16/14.
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] data = {3, 0, -110, 90, 1, 2, 78, 6, 8, 34, 7, 8 };

//        quickSort(data);
//
//
//        System.out.println(Arrays.toString(data));
//
//        System.out.println(binarySearch(data, 6, 10, data.length - 1));


        System.out.println(threeSum(data, 3));
        System.out.println(threeSum(data, 1));
    }


    private static boolean threeSum(int[] data, int sum){

        quickSort(data);
        System.out.println(Arrays.toString(data));

        for(int fix = 0; fix < data.length - 3; fix++){
            if(isTwoSum(data, sum - data[fix], fix + 1)){
                System.out.println("fix "+data[fix]);
                return true;
            }
        }

        return false;
    }

    private static boolean isTwoSum(int[] data, int sum, int start) {

        int end = data.length - 1;

        while(start < end){
            int ans = data[start] + data[end];
            if(ans == sum){
                System.out.printf(" start %3d, end %3d ",data[start], data[end]);
                return true;
            }else if(ans > sum){
                end--;
            }else{
                start++;
            }
        }

        return false;
    }





    private static void quickSort(int[] data){
        quickSortHelper(data, 0, data.length - 1);
    }

    private static void quickSortHelper(int[] data, int start, int end) {
        if(end - start > 0){
            int p = partation(data, start, end);
            quickSortHelper(data, start, p - 1);
            quickSortHelper(data, p + 1, end);
        }
    }


    private static int partation(int[] data, int start, int end){
        int equal = start;
        int pivot = data[start];

        while(equal <= end){
            if(data[equal] == pivot){
                equal++;
            }else if(data[equal] < pivot){
                swap(data, equal, start);
                start++;
                equal++;
            }else{
                swap(data, equal, end);
                end--;
            }
        }


        return equal - 1;
    }

    private static void swap(int[] data, int src, int target) {
        int temp = data[src];
        data[src] =  data[target];
        data[target] =  temp;
    }

}
