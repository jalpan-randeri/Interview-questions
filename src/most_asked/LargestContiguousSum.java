package most_asked;

/**
 * Given an array of integers (positive and negative) find the largest continuous sum.
 * - See more at: http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.BgLHYvZ6.dpuf
 *
 * Created by jalpanranderi on 11/4/14.
 */
public class LargestContiguousSum {

    public static void main(String[] args) {
        int[] data = {-1,-3,4,-3,7};
        System.out.printf("larges sum is %3d\n", largestSum(data));

        if(true){
            System.out.println("firste");
        }else if(true){
            System.out.println("second");
        }else if(false){
            System.out.println("thirst");
        }


    }

    private static int largestSum(int[] arr){
        int maxSum = arr[0];
        int curr_sum  = maxSum;

        for(int a : arr){
            curr_sum = max(a, curr_sum + a);
            maxSum = max(curr_sum, maxSum);
        }

        return maxSum;
    }


    private static int max(int a, int b){
        return a > b ? a : b;
    }








}
