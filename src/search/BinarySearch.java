package search;

/**
 *
 * Complexity : O(log n)
 *
 * Created by jalpanranderi on 9/17/14.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] space = {1,2,3,4,5,6,7,8};

        System.out.printf(" Element found at position %2d \n", binarySearchIterative(space, 40));
        System.out.printf(" Element found at position %2d \n", binarySearchIterative(space, 1));
        System.out.printf(" Element found at position %2d \n", binarySearchIterative(space, 8));
        System.out.printf(" Element found at position %2d \n", binarySearchIterative(space, 7));
        System.out.printf(" Element found at position %2d \n", binarySearchIterative(space, 3));


        System.out.printf(" Element found at position %2d \n", binarySearchRecursive(space, 40, 0, space.length - 1));
        System.out.printf(" Element found at position %2d \n", binarySearchRecursive(space, 1, 0, space.length - 1));
        System.out.printf(" Element found at position %2d \n", binarySearchRecursive(space, 8, 0, space.length - 1));
        System.out.printf(" Element found at position %2d \n", binarySearchRecursive(space, 7, 0, space.length - 1));
        System.out.printf(" Element found at position %2d \n", binarySearchRecursive(space, 3, 0, space.length - 1));


    }



    private static int binarySearchIterative(int[] space, int element){
        int low = 0;
        int high = space.length - 1;
        int mid;
        while(low <= high){
            mid = high + low >> 1;
            if(space[mid] == element){
                return mid;
            }else if(space[mid] > element){
                // search in left halve
                high = mid - 1;
            }else{
                // search in right halve
                low = mid + 1;
            }
        }

        return -1;
    }

    private static int binarySearchRecursive(int[] space, int element, int low, int high){

        if(low > high){
            return -1;
        }else{
            int mid = low + high >> 1;
            if(space[mid] > element){
                return binarySearchRecursive(space, element, low, mid - 1);
            }else if( space[mid] < element){
                return binarySearchRecursive(space, element, mid + 1, high);
            }else{
                return mid;
            }
        }
    }


}
