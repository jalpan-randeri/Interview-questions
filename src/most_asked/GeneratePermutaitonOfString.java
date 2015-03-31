package most_asked;

/**
 *
 * Generate all permutations of a given string.
 *
 *
 * Created by jalpanranderi on 11/6/14.
 */
public class GeneratePermutaitonOfString {

    public static void main(String[] args) {
        permute("abc");
    }


    private static void permute(String s){
       permute(s.toCharArray(), 0);
    }

    private static void permute(char[] str, int index){
        if(index == str.length){
            System.out.println(String.valueOf(str));
        }else{
            for(int i=index; i < str.length; i++ ){
                str = swap(i, index, str);
                permute(str, index + 1);
                str = swap(i, index, str);
            }
        }
    }

    private static char[] swap(int i, int j, char[] str) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;

        return str;
    }

}
