package search;

/**
 * Created by jalpanranderi on 10/16/14.
 */
public class FirstLargerThanK {
    public static void main(String[] args) {
        int[] data = {1,1,1,1,3,5,6,7,8};

        System.out.printf("larger than %3d index is %2d\n",6,findLargestThanK(data,6));
        System.out.printf("larger than %3d index is %2d\n",1,findLargestThanK(data,1));
        System.out.printf("larger than %3d index is %2d\n",8,findLargestThanK(data,8));
    }


    private static int findLargestThanK(int[] data, int k){
        return findLargestThanKHelper(data, k, 0, data.length - 1, -1);
    }

    // time  = O(log n)
    // space = O(log n)  can be improved using iterative version
    private static int findLargestThanKHelper(int[] data, int k, int low, int high, int invariant) {
        if(low > high){
            return invariant != -1 ? (invariant + 1 < data.length ? data[invariant + 1] : -1) : -1;
        }else{
            int mid = low + high >> 1;
            if(data[mid] == k){
                return findLargestThanKHelper(data, k, mid + 1, high, mid);
            }else if(k > data[mid]){
                return findLargestThanKHelper(data, k, mid + 1, high, invariant);
            }else{
                return findLargestThanKHelper(data, k, low, mid - 1, invariant);
            }
        }
    }

}
