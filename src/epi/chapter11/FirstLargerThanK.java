package epi.chapter11;

/**
 * Created by jalpanranderi on 11/25/14.
 */
public class FirstLargerThanK {
    public static void main(String[] args) {
        int[] data = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
        System.out.println(getFirstElementLarger(data, 500));
        System.out.println(getFirstElementLarger(data, 101));

    }


    public static int getFirstElementLarger(int[] data, int k){
        int start = 0;
        int end = data.length - 1;
        int res = -1;

        while( start <= end){
            int mid = start + end >> 1;
            if(k < data[mid]){
                end = mid - 1;
                res  = mid;
            }else{
                start = mid + 1;
            }
        }
        return res;
    }

}
