package elements_of_programming_interview.chapter1;

/**
 * Created by jalpanranderi on 11/19/14.
 */
public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(convertToInteger("123"));
        System.out.println(convertToInteger("-123"));
        System.out.println(convertToInteger("123abc"));
    }


    public static int convertToInteger(String s){
        int number = 0;
        boolean nagative = false;
        int i = 0;

        if(s.charAt(0) == '-'){
            nagative = true;
            i++;
        }

        for(; i < s.length(); i++){
            char c = s.charAt(i);

            if( c >= '0' && c <= '9'){
                int digit = c - '0' ;
                number = number + digit;
                number = number * 10;
            }else{
                throw new NumberFormatException("invalid char");
            }
        }

        return nagative ? -number : number;
    }

}
