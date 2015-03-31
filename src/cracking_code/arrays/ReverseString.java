package cracking_code.arrays;

import java.util.Arrays;

/**
 * Implement a function void reverse to reverse null terminated string
 *
 * Created by jalpanranderi on 10/21/14.
 */
public class ReverseString {

    static char[] data = "jalpan\0     ".toCharArray();

    public static void main(String[] args) {

        System.out.printf("%s is reversed %s\n", Arrays.toString(data),Arrays.toString(reverse(data)));
    }

    // time  = O(n)
    // space = O(1)
    private static char[] reverse(char[] string){

        boolean flag = true;
        for(int i=0, j = 0; i < string.length; ){
            if(string[i] != '\0' && flag){
                i++;
            }else if(j < i && !flag){

                string[i] = (char) (string[i] ^ string[j]);
                string[j] = (char) (string[i] ^ string[j]);
                string[i] = (char) (string[i] ^ string[j]);
                j++;
                i--;
            }else if (flag){
                i--;
                flag = false;
            }else {
                break;
            }
        }

        return string;
    }
}
