package epi.chapter11;

/**
 * Created by jalpanranderi on 11/25/14.
 */
public class FirstOccurenceOfK {
    public static void main(String[] args) {
        int[] data = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
        System.out.println(getFirstOccurence(data, 108));
        System.out.println(getFirstOccurence(data, 285));
        System.out.println(getFirstOccurence(data, 400));
    }

    public static int getFirstOccurence(int[] data, int k){
        int start = 0;
        int end = data.length - 1;

        int ans = -1;

        while(start <= end){
            int mid = (start + end) >> 1;
            if( data[mid] == k){
                ans = mid;
                end = mid - 1;
            }else if( k > data[mid]) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;
    }

}
