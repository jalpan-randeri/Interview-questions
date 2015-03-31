package cracking_code.arrays;

import java.util.HashMap;

/**
 * Created by jalpanranderi on 10/21/14.
 */
public class PermutationOfOther {
    public static void main(String[] args) {
        System.out.printf("is %10s permutation of %10s : %5s\n","jalpan","njplaa",isPermutation("jalpan","njplaa"));
        System.out.printf("is %10s permutation of %10s : %5s\n","jalpan","njplaaa",isPermutation("jalpan","njplaaa"));
    }


    // time  = O(n)  where n is character in string
    // space = O(n)
    private static boolean isPermutation(String string1, String string2){
        HashMap<Character, Integer> state =  new HashMap<>();

        for(char c : string1.toCharArray()){
            if(state.containsKey(c)) {
                int frequency = state.get(c);
                state.put(c,++frequency);
            }else{
                state.put(c,1);
            }
        }

        for(char c: string2.toCharArray()){
            if(state.containsKey(c)){
                int frequency = state.get(c);
                if(frequency == 1){
                    state.remove(c);
                }else{
                    state.put(c, --frequency);
                }
            }else{
                return false;
            }
        }

        return state.size() == 0;
    }

}



