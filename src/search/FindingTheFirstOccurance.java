package search;

/**
 * Created by jalpanranderi on 10/16/14.
 */
public class FindingTheFirstOccurance {
    public static void main(String[] args) {
        int[] data = {1,1,10,10,10};

        System.out.printf(" Key index is %d \n",getFirstOccurence(data,10));
    }


    private static int getFirstOccurence(int[] data, int key){
        return getFirstOccurenceHelper(data, 0, data.length, key, -1);
    }

    private static int getFirstOccurenceHelper(int[] data, int low, int high, int key, int invariant) {
        System.out.printf(" low is %3d high is %3d \n",low,high);
            if(low > high){
                return invariant != -1 ? invariant : -1;
            }else{
                int mid = (high + low) >> 1;
                System.out.printf(" mid is %3d \n",mid);
                if(data[mid] == key){
                    return getFirstOccurenceHelper(data,low, mid - 1, key, mid);
                }else if( key < data[mid]){
                    return getFirstOccurenceHelper(data, low, mid - 1, key,invariant);
                }else{
                    return getFirstOccurenceHelper(data, mid + 1, high, key, invariant);
                }
            }

    }
}
