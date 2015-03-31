package last_minute;

/**
 * Created by jalpanranderi on 11/24/14.
 */
public class Permutation {

    public static void main(String[] args) {
        permute("abc");
    }

    public static  void permute(String str){
        boolean[] state = new boolean[str.length()];
        permuteHelper(str.toCharArray(), state, new StringBuilder());
    }

    private static  void permuteHelper(char[] str, boolean[] state, StringBuilder builder){
        if(builder.length() == str.length){
            System.out.println(builder);
        }else{
            for(int i = 0; i < str.length; i++){
                if(state[i]){
                    continue;
                }
                builder.append(str[i]);
                state[i] = true;
                permuteHelper(str, state, builder);
                state[i] = false;
                builder.setLength(builder.length() - 1);
            }
        }
    }

    private static void swap(char[] str, int src, int target) {
        char c = str[src];
        str[src] = str[target];
        str[target] = c;
    }
}
