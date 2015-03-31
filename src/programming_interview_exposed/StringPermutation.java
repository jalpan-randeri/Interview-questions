package programming_interview_exposed;

/**
 * Created by jalpanranderi on 11/17/14.
 */
public class StringPermutation {
    public static void main(String[] args) {
        permuteV2("abc".toCharArray(), 0);

        permute("abc");

    }


    private static void permute(String str){
        StringBuilder builder = new StringBuilder();
        boolean[] used = new boolean[str.length()];

        permuteHelper(str, used, builder);
    }

    private static void permuteHelper(String str, boolean[] used, StringBuilder builder) {
        if(builder.length() == str.length()){
            System.out.println(builder.toString());
        }else{
            for(int i = 0; i < str.length(); i++){
                if(!used[i]){
                    used[i] = true;
                    builder.append(str.charAt(i));
                    permuteHelper(str, used, builder);
                    used[i] = false;
                    builder.setLength(builder.length() - 1);
                }
            }
        }
    }

    private static void permuteV2(char[] str, int curr){
        if(curr == str.length - 1){
            System.out.println(String.valueOf(str));
        }else{
            for(int i=curr; i < str.length; i++){
                swap(str, curr, i);
                permuteV2(str, curr + 1);
                swap(str, curr, i);
            }
        }
    }

    private static void swap(char[] str, int src, int target) {
        char c = str[src];
        str[src] = str[target];
        str[target] = c;
    }
}
