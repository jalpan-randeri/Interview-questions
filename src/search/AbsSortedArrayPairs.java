package search;

/**
 * Created by jalpanranderi on 10/17/14.
 */
public class AbsSortedArrayPairs {
    public static void main(String[] args) {
        int[] data = {-49, 75, 103, -147, 164, -197, -238, 314, 348, -422};

        System.out.printf(" Pair is %s\n",getPair(data, 167));
        System.out.printf(" Pair is %s\n",getPair(data, 26));
        System.out.printf(" Pair is %s\n",getPair(data, -471));
    }

    // time  = O(n log n)
    // space = O(1)
    private static Pair getPair(int[] data, int sum){
        int low = 0;
        int high = data.length - 1;
        int ans;

        // time  = O(n)
        for(int first = 0; first < data.length - 1; first++){
            int other = sum - data[first];

            if(Math.abs(other) > Math.abs(data[first])){
                ans = getPossibleAnswer(data, other, first, high);
            }else{
                ans = getPossibleAnswer(data, other, low, first);
            }

            if(ans != -1){
                return new Pair(first, ans);
            }
        }

        return new Pair(-1,-1);
    }

    // time == O(log n)
    private static int getPossibleAnswer(int[] data, int ans, int low, int high){
        while(low <= high){
            int mid = low + high >> 1;
            if(ans == data[mid]){
                return mid;
            }else if( Math.abs(ans) > Math.abs(data[mid])){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }




    public static class Pair{
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        int x;
        int y;

        public String toString(){
            return "("+x+" , "+y+")";
        }
    }
}
