package amazon;

/**
 * Created by jalpanranderi on 12/10/14.
 */
public class Permutation {
    public static void main(String[] args) {
        permute("abcd");
    }


    public static void permute(String str){
        permuteHelper(str.toCharArray(), new boolean[str.length()], 0);
    }


    private static void permuteHelper(char[] str, boolean[] used, int n){
        if(n == str.length){
            System.out.println(String.valueOf(str));
        }else{
            for(int i = 0; i < used.length; i++){
                if(used[i]){
                    continue;
                }
                used[n] = true;
                swap(str, i, n);
                permuteHelper(str, used, n + 1);
                swap(str, i, n);
                used[n] = false;
            }
        }
    }


    private static void swap(char[] data, int src, int tar){
        char temp = data[src];
        data[src] = data[tar];
        data[tar] = temp;
    }
}
