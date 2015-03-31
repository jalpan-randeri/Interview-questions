package search;

/**
 * Created by jalpanranderi on 10/17/14.
 */
public class FindMinimumElementSortedCircularArray {
    public static void main(String[] args) {
        int[] data = {378, 478, 550, 631, 103, 203, 220, 234, 279, 368};

        System.out.printf("Minimum number is %4d\n",getMinimumElement(data));
    }

    // time  = O(log n)
    // space = O(1)
    private static int getMinimumElement(int[] data){
        int low = 0;
        int high = data.length - 1;
        int answer = Integer.MAX_VALUE;
        while(low < high) {
            int mid = low + high >> 1;

            if(answer > data[mid]){
                answer = data[mid];
            }

            if(data[mid] > data[low]){
                high = mid - 1;
            }else if(data[mid] > data[high]){
                low = mid -1;
            }else{
                high = mid;
            }
        }
        return  answer;
    }
}
