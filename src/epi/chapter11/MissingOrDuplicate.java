package epi.chapter11;

/**
 * Created by jalpanranderi on 11/26/14.
 */
public class MissingOrDuplicate {
    public static void main(String[] args) {
        int[] data = {6,7,4,3,2};

        System.out.println(getMissingOrDuplicate(data));
    }


    public static int getMissingOrDuplicate(int[] data){
        int missOrDuplicate = 0;
        for(int i = 0; i < data.length; i++){
            missOrDuplicate ^= i ^ data[i];
        }

        int diff = missOrDuplicate & (~(missOrDuplicate -  1));
        int miss = 0;

        for(int i = 0; i < data.length; i++){
            if((i & diff) == 1){
                miss ^= i;
            }

            if((data[i] & diff) == 1){
                miss ^= data[i];
            }
        }

        for(int i = 0; i < data.length; i++){
            if(i == miss){
                return miss ^ missOrDuplicate;
            }
        }

        return miss;
    }
}
