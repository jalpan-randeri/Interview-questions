package onsite;

/**
 * Created by jalpanranderi on 12/3/14.
 */
public class PatternMatching {
    public static void main(String[] args) {
        System.out.println(isFollows("abba", "redbluebluered" ));
    }


    public static  boolean isFollows(String pattern, String input){
        int matcher_key = 0;
        for(int i = 0; i < input.length(); i++){
            if(pattern.charAt(matcher_key) == input.charAt(i)){
                matcher_key++;
            }else if(pattern.contains(String.valueOf(input.charAt(i)))){
                matcher_key = 0;
            }
        }

        return matcher_key == pattern.length() - 1;
    }
}
