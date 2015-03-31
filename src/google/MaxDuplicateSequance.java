package google;

import java.util.Arrays;

/**
 * Created by jalpanranderi on 11/20/14.
 */
public class MaxDuplicateSequance {
    public static void main(String[] args) {

        int[] data = {1,2,3,4,4,4,4,5,6,7,7,7,7,7,7,7,8};
        System.out.println(Arrays.toString(logestSubsequance(data)));


    }

    public static int[] logestSubsequance(int[] data){

        int end = 0;
        int maxLength = 0;
        int count = 1;
        int prev = data[0];

        for(int i = 1; i < data.length; i++){
            if(data[i] ==  prev){
                count++;
            }else{
                if(count > maxLength){
                    maxLength = count;
                    end = i - 1;
                }
                prev = data[i];
                count = 1;
            }
        }

        int[] sequance = new int[maxLength];
        for(int i = sequance.length - 1; maxLength > 0; i--, maxLength--){
            sequance[i] = data[end--];
        }

        return sequance;
    }


}
