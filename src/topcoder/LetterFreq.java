package topcoder;

/**
 * Created by jalpanranderi on 10/29/14.
 */
public class LetterFreq {

    public int[] getFreqs(String[] doc){
        int[] freq = new int[26];

        for(String line : doc){
            for(char c: line.toLowerCase().toCharArray()){
                if(c >= 'a' && c <= 'z'){
                    freq[c - 'a']++;
                }
            }
        }

        return freq;
    }
}
