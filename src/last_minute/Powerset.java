package last_minute;

import java.util.ArrayList;

/**
 * Created by jalpanranderi on 11/24/14.
 */
public class Powerset {

    public static void main(String[] args) {
        System.out.println(powerset("abc".toCharArray()));
    }

    public static ArrayList<String> powerset(char[] data){
        return powersetHelper(data, new ArrayList<String>());
    }


    private static ArrayList<String> powersetHelper(char[] data, ArrayList<String> history){

        for(int i = 0; i < data.length; i++){
            int count = history.size();
            history.add(data[i]+"");
            for(int j = 0; j < count ; j++){
                history.add(history.get(j)+data[i]);
            }

        }
        return history;
    }
}
