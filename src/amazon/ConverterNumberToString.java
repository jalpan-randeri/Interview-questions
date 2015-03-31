package amazon;

/**
 * Created by jalpanranderi on 12/9/14.
 */
public class ConverterNumberToString {
    public static void main(String[] args) {
        System.out.println(convert(12.10f));
    }


    public static String convert(float no){

        String ans = "";

        while(no > 0){
            int index = (int) (no % 10);
            ans = index + ans;
            no = no / 10;
        }

        return ans;
    }
}
