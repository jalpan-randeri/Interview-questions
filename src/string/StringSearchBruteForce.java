package string;

/**
 * Created by jalpanranderi on 9/23/14.
 */
public class StringSearchBruteForce {

    public static void main(String[] args) {

        System.out.printf(" is jal exists in jalpan %2d ",searchString("jalpan", "jal"));

    }


    public static int searchString(String data, String pattern){
        return searchStringHelper(data.toCharArray(), pattern.toCharArray());
    }

    private static int searchStringHelper(char[] data, char[] pattern) {

        for(int i=0; i < data.length - pattern.length; i++){
            int count = 0;

            while(count < pattern.length && data[i + count] == pattern[count]){
                count++;
            }

            if(count == pattern.length){
                return i;
            }
        }

        return -1;
    }


}
