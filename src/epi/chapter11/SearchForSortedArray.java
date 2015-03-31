package epi.chapter11;

/**
 * Created by jalpanranderi on 11/26/14.
 */
public class SearchForSortedArray {
    public static void main(String[] args) {
        int[] data = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};


        System.out.println(searchSortedArray(data));
    }


    public static int searchSortedArray(int[] data){
        int start = 0;
        int end = data.length;

        while(start <= end){
            int mid = (start + end) >> 1;
            int temp = data[mid] - mid;
            if(temp == 0){
                return mid;
            }else if(temp < 0){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return -1;
    }

}
