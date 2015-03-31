package search;

/**
 * Created by jalpanranderi on 10/17/14.
 */
public class IisequalToArrayOfI {
    public static void main(String[] args) {
        int[] data = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};

        System.out.printf("The required element is %2d\n",isEqualToArrayOfI(data));

        data = new int[] {-14, -10, 3, 108, 108, 243, 285, 285, 285, 401};
        System.out.printf("The required element is %2d\n",isEqualToArrayOfI(data));

        data = new int[]{-14, -10, 1, 2, 3, 4, 6, 285, 285, 401};
        System.out.printf("The required element is %2d\n",isEqualToArrayOfI(data));
    }


    private static int isEqualToArrayOfI(int[] data){
        return isEqualToArrayOfIHelper(data, 0, data.length - 1);
    }


    // time  = O(log n)
    // space = O(log n) can be improved to O(1) using iterative version
    private static int isEqualToArrayOfIHelper(int[] data, int low, int high) {
        if(low > high){
            return -1;
        }else{
            int mid = low + high >> 1;
            if(mid == data[mid]){
                return mid;
            }else if(mid > data[mid]){
                return isEqualToArrayOfIHelper(data, mid + 1, high);
            }else{
                return isEqualToArrayOfIHelper(data, low, mid - 1);
            }
        }
    }
}
