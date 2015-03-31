package search;

/**
 * Created by jalpanranderi on 10/16/14.
 */
public class LastOccurence {
    public static void main(String[] args) {
        int[] data = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,};

        System.out.printf(" Key index is %d \n",getLastOccurence(data,10));
    }


    private static int getLastOccurence(int[] data, int key){
        return getLastOccurenceHelper(data, key, 0, data.length - 1, -1);
    }

    private static int getLastOccurenceHelper(int[] data, int key, int low, int high, int invariant) {
        if(low > high){
            return invariant != -1 ? invariant : -1;
        }else{
            int mid = low + high >> 1;
            System.out.printf("Mid is %2d\n",mid);
            if(data[mid] == key){
                return getLastOccurenceHelper(data, key, mid + 1, high, mid);
            }else if(key < data[mid]){
                return getLastOccurenceHelper(data, key, low, mid - 1, invariant);
            }else{
                return getLastOccurenceHelper(data, key, mid + 1, high, invariant);
            }
        }
    }
}
