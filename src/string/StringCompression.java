package string;

/**
 * Created by jalpanranderi on 11/1/14.
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress("aabbddeegggg"));
    }


    private static String compress(String str){

        if(getCount(str) < str.length()) {


            StringBuilder builder = new StringBuilder(str.length());
            char c = str.charAt(0);
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == c) {
                    count++;
                } else {
                    builder.append(c);
                    builder.append(count);
                    c = str.charAt(i);
                    count = 1;
                }
            }

            builder.append(c);
            builder.append(count);

            return builder.toString();
        }else{
            return str;
        }

    }

    private static int getCount(String str) {
        int count = 0;
        int c = str.charAt(0);

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) != c){
                c = str.charAt(i);
                count = count + 2;
            }
        }
        count = count + 2;

        return count;
    }
}
