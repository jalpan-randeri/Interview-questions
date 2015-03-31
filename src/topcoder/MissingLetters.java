package topcoder;

/**
 * Created by jalpanranderi on 10/29/14.
 */
public class MissingLetters {


    public static void main(String[] args) {
        new MissingLetters().getMissingLetters("Lions, and tigers, and bears, oh my!");
    }

    public String getMissingLetters(String sentence){
        boolean[] abc = new boolean[26];

        StringBuilder sb = new StringBuilder(26);

        for(char c: sentence.toLowerCase().toCharArray()){
            if(c >= 'a' && c <='z') {
                int index = c - 'a';
                System.out.println(index);
                abc[index] = true;
            }
        }

        for(int i=0; i<abc.length; i++){
            if(!abc[i]){
                char c = (char) ('a'+i);
                sb.append(c);
            }
        }

        return sb.toString().toUpperCase();
    }
}
