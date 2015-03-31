package epi.chapter11;

/**
 * Created by jalpanranderi on 11/26/14.
 */
public class SearchSmallestInSortedCyclicArray {
    public static void main(String[] args) {

        int[] data = { 285, 285, 401, -14, -10, 2, 108, 108, 243, 285};
        System.out.println(getSmallest(data));
    }


    public static int getSmallest(int[] data){
        int start = 0;
        int end = data.length - 1;

        while(start < end){
            int mid = start + end >> 1;

            if(data[mid] > data[end]){
                // small element is in mid - end range
                start = mid + 1;
            }else{
                // small element is in start - mid range
                end =  mid;
            }
        }
        return data[start];
    }

}
