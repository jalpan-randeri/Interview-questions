/**
 * Created by jalpanranderi on 10/29/14.
 */
public class Permutation {


    private static int count;

    public static void main(String[] args) {

        permute("abc");

    }


//    private static void permute(String str){
//       permuteHelper(0, str.toCharArray());
//    }
//
//   private static void permuteHelper(int start, char[] data){
//       if(start == data.length){
//           System.out.println(String.valueOf(data));
//       }else{
//           for(int i = start; i < data.length; i++){
//               data = swap(data, i, start);
//               permuteHelper(start + 1, data);
//               data = swap(data, i, start);
//           }
//       }
//   }
//
//    private static char[] swap(char[] data, int src, int target) {
//        char c = data[src];
//        data[src] = data[target];
//        data[target] = c;
//
//        return data;
//    }




    private static void permute(String str){

        permuteHelper(str.toCharArray(), 0);

    }


    private static void permuteHelper(char[] str, int start){
        if(start == str.length){
//            count = count+1;
            System.out.println(String.valueOf(str));
        }else{
            for(int i = start; i < str.length; i++){
                str = swap(str, start, i);
                permuteHelper(str, start + 1);
                str = swap(str, start, i);
            }

        }

    }

    private static char[] swap(char[] str, int start, int i) {
        char c = str[start];
        str[start] = str[i];
        str[i] = c;
        return str;
    }


}
