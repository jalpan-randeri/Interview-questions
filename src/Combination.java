import java.util.ArrayList;


/**
 * Created by jalpanranderi on 10/30/14.
 */
public class Combination {


    public static void main(String[] args) {
        combination("abc");
    }

    public static void combination(String s){

        ArrayList<String> prev = new ArrayList<>();

        for(char c : s.toCharArray()){
            prev = combHelper(c, prev);
        }

        System.out.println(prev.size());
    }

    private static ArrayList<String> combHelper(char c, ArrayList<String> prev){
        ArrayList<String> temp = new ArrayList<>();
        temp.addAll(prev);
        temp.add(String.valueOf(c));

        for(String s: prev){
            temp.add(s+c);
        }



        return temp;
    }
}
