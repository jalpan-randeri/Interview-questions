package elements_of_programming_interview.chapter1;

import java.util.ArrayList;

/**
 * Created by jalpanranderi on 11/19/14.
 */
public class PowerSet {
    public static void main(String[] args) {
        powerset(new char[]{'a','b','c'});
    }


    public static void powerset(char[] ip){
        ArrayList<String> history = new ArrayList<String>();
        powersetHelper(ip, history, 0);


    }

    private static void powersetHelper(char[] ip, ArrayList<String> history, int curr){

        if(curr == ip.length){
            for(String s : history){
                System.out.println(s);
            }
        }else{

            int length = history.size();
            history.add(String.valueOf(ip[curr]));
            for(int i = 0; i < length; i++){
                history.add(history.get(i) + ip[curr]);
            }

            powersetHelper(ip, history, curr + 1);
        }
    }

}
