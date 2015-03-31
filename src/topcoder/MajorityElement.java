package topcoder;

/**
 * Created by jalpanranderi on 11/8/14.
 */
import java.util.HashMap;

public class MajorityElement{

    public static void main(String[] args) {
        int[] data = {0, 1000, 984, 0};

        System.out.println(findMajorElement(data));
    }


    public static  int findMajorElement(int[] a){

        HashMap<Integer, Integer> state = new HashMap<>();
        int half = a.length >> 1;
        int count = -1;
        for(int i = 0; i < a.length; i++){
            if(state.containsKey(a[i])){
                count = state.get(a[i]) + 1;
                state.put(a[i], state.get(a[i]) + 1);
                if( count >= half){
                    return a[i];
                }
            }else{
                if(count >= half){
                    return a[i];
                }
                state.put(a[i], 1);
            }
        }

        return -1;

    }

}
