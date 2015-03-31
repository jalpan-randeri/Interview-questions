package arrays;

/**
 * Created by jalpanranderi on 10/21/14.
 */
public class MissingElement {
    public static void main(String[] args) {
        int[] seq = {7,8,9,4,5};
        System.out.println(missingElementFromSequance(seq));
    }


    private int getMissingElement(int[] data){
        int state = 0;
        int ans = 0;
        for(int i=0 ; i <data.length; i++){
            state ^= i;
            ans ^= data[i];
        }

        return ans ^ state;
    }


    private static int missingElementFromSequance(int[] arr){
        int state = 0;
        for(int a : arr){
            state = state | (1 << a);
        }

        boolean flag = true;
        int count = 0;

        while(state > 0){
            int i = state & 1;
            if(i == 1){
                flag = false;
            }else if(!flag){
                return count;
            }
            state = state >> 1;
            count++;
        }

        return -1;
    }
}
