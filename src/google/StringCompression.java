package google;

/**
 * Created by jalpanranderi on 11/20/14.
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress("aaaa"));
    }


    public static String compress(String str){
        StringBuilder builder = new StringBuilder();

        int count = 1;
        char prev =  str.charAt(0);

        for(int i = 1; i < str.length(); i++){
            char c  = str.charAt(i);
            if(c == prev){
                count++;
            }else{
                builder.append(prev);
                builder.append(count);
                prev = c;
                count = 1;
            }
        }

        builder.append(prev);
        builder.append(count);

        return builder.toString();
    }
}
