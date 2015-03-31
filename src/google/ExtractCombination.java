package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jalpanranderi on 11/20/14.
 */
public class ExtractCombination {

    public static void main(String[] args) {
        String word = "abc";
        String target = "abcdefgbcahijkacb12df";


        System.out.println(extractCombinations(word, target));
    }


    public static List<String> extractCombinations(String word, String target){

        ArrayList<String> list = new ArrayList<>();
        for(int i =0; i < target.length() - word.length() - 1; ){
            String sub_word = target.substring(i, i + word.length());
            if(isCombination(sub_word, word)){
                list.add(sub_word);
                i = i + 3;
            }else{
                i = i + 1;
            }
        }

        return list;

    }

    private static boolean isCombination(String src, String givenWord){
        HashMap<Character, Integer> state = new HashMap<>();
        for(char c : givenWord.toCharArray()){
            if(state.containsKey(c)){
                state.put(c, state.get(c) + 1);
            }else{
                state.put(c, 1);
            }
        }

        for(char c : src.toCharArray()){
            if(state.containsKey(c)){
                int count = state.get(c);
                if(count == 1){
                    state.remove(c);
                }else{
                    state.put(c, count - 1);
                }
            }else{
                return false;
            }
        }


        return state.isEmpty();
    }

}
