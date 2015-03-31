package epi.chapter11;

/**
 * Created by jalpanranderi on 11/26/14.
 */
public class SearchForArrayUnknownLength {
    public static void main(String[] args) {
        int[] data = { -14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
        System.out.println(search(data, 401));
    }


    public static int search(int[] data, int k){
        int pivot = 0;

        while(true){

            try{
                int temp = (1 << pivot) - 1;
                if(data[temp] == k){
                    return k;
                }else if(data[temp] > k){
                    break;
                }
            }catch(ArrayIndexOutOfBoundsException e){
                break;
            }
            pivot++;
        }

        int start = 0;
        int end = (1 << pivot) - 1;
        while(start <= end){
            int mid = start + end >> 1;
            try{
                if(data[mid] == k){
                    return mid;
                }else if(data[mid] > k){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            } catch(ArrayIndexOutOfBoundsException e){
                end = mid;
            }

        }
        return -1;
    }
}
