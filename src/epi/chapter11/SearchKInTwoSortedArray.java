package epi.chapter11;

/**
 * Created by jalpanranderi on 11/26/14.
 */
public class SearchKInTwoSortedArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        int[] b = {7,8,9,10};

        System.out.println(getKthElement(a, b, 8));

    }


    public static int getKthElement(int[] a, int[] b, int k){

        int l = Math.max(0, k - b.length);
        int u = Math.min(a.length, k);

        while (l < u){
            int mid = l + u >> 1;

            int A_x_1 = (mid <= 0 ? Integer.MIN_VALUE : a[mid - 1]);
            int A_x = (mid >= a.length ? Integer.MAX_VALUE : a[mid]);
            int B_k_x_1 = (k - mid <= 0 ? Integer.MIN_VALUE : b[k - mid - 1]);
            int B_k_x = (k - mid >= b.length ? Integer.MAX_VALUE : b[k - mid]);

            if(A_x < B_k_x_1){
                l = mid + 1;
            }else if(A_x_1 > B_k_x){
                u = mid - 1;
            }else {
                return Math.max(A_x_1, B_k_x_1);
            }
        }

        int A_l_1 = l <= 0 ? Integer.MIN_VALUE : a[l - 1];
        int B_k_l_1 = k - l - 1 < 0 ? Integer.MIN_VALUE : b[k - l - 1];

        return Math.max(A_l_1, B_k_l_1);
    }












}
