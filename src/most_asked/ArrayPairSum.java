package most_asked;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * Given an integer array, output all pairs that sum up to a specific value k.
 * - See more at: http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.BgLHYvZ6.dpuf
 *
 * Created by jalpanranderi on 11/3/14.
 */
public class ArrayPairSum {
    public static void main(String[] args) {
        int[] data = {5,4,3,2,1};
        sumpairs(data,6);

        improvedTimeSumPair(data, 6);
    }

    // assumption all elements are unique
    // time  = O(n log n)
    // space = O(1)
    private static void sumpairs(int[] arr, int sum){
        Arrays.sort(arr);

        for(int low = 0, high = arr.length - 1; low < high; ){
            int temp = arr[low] + arr[high];

            if(temp == sum){
                System.out.printf("%2d + %2d = %2d\n",arr[low], arr[high], sum);
                high--;
                low++;
            }else if(temp > sum){
                high--;
            }else{
                low++;
            }

        }
    }

    // time  = O(n)
    // space = O(n)
    private static void improvedTimeSumPair(int[] arr, int sum){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int anArr : arr) {
            map.put(anArr, anArr);
        }

        for(int ele : arr){
            if(map.containsKey(sum - ele)){
                System.out.printf("%2d + %2d = %2d\n",ele, sum - ele, sum);
            }
        }
    }
}
