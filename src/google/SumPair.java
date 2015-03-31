package google;

/**
 * Created by jalpanranderi on 11/20/14.
 */
public class SumPair {

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,5,5,6,7,8};

        System.out.println(binarySearch(data, 5, 0, data.length, -1));
        System.out.println(getPairCount(data, 5));

        System.out.println(getPairCount(data, 9));
    }

    public static int getPairCount(int[] data, int sum){
        int count = 0;
        int maxIndex = binarySearch(data, sum, 0, data.length - 1, -1);    // O(log n)

        System.out.println("Search range is 0 - "+maxIndex);

        for(int i =0; i <= maxIndex; i++){                   // O(m^2)
            for(int j = i + 1; j <= maxIndex; j++){
                if(data[i] + data[j] < sum){
                    count++;
                }
            }
        }

        return count;
    }




    private static int binarySearch(int[] data, int sum, int start, int end, int accu){
        if(end >= start){
            int mid = start + end >> 1;

            if(data[mid] == sum){
                return  binarySearch(data, sum, start, mid - 1, accu);
            }else if (data[mid] < sum){
                return binarySearch(data, sum, mid + 1, end, mid);
            }else{
                return binarySearch(data, sum, start,  mid, accu);
            }
        }else{
            return accu;
        }
    }

}
