package programming_interview_exposed;

import java.util.ArrayList;

/**
 * Created by jalpanranderi on 11/17/14.
 */
public class StringCombination {
    public static void main(String[] args) {
        getCombinations("abc");
    }





    public static void getCombinations(String text) {
        ArrayList<String> results = new ArrayList<String>();
        for (int i = 0; i < text.length(); i++) {

            int resultsLength = results.size();
            for (int j = 0; j < resultsLength; j++) {
                results.add(results.get(j) + text.charAt(i) );
            }
            results.add(Character.toString(text.charAt(i)));
        }

        System.out.println(results);
    }

}
