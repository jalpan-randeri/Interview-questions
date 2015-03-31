package string;

/**
 * Created by jalpanranderi on 11/1/14.
 */
public class PalindromRecursion {

    public static void main(String[] args) {
        System.out.println(isPalindrom("aa"));
        System.out.println(isPalindrom("aba"));
        System.out.println(isPalindrom("abc"));
        System.out.println(isPalindrom("wasitaratisaw"));

    }


    private static boolean isPalindrom(String str){
        if(str.length() == 0 || str.length() == 1){
            return true;
        }else{
            if(str.charAt(0) == str.charAt(str.length() - 1)){
                return isPalindrom(str.substring(1,str.length() - 1));
            }else{
                return false;
            }
        }
    }
}
