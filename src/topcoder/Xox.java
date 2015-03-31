package topcoder;

import java.util.ArrayList;

/**
 * Created by jalpanranderi on 10/26/14.
 */
public class Xox{

    public static void main(String[] args) {
//        System.out.println(getCount("xox"));
//        System.out.println(getCount("aaaxox"));
//        System.out.println(getCount("axoxoxxox"));
//        System.out.println(getCount("asxoxsxo"));

    }

    public int count(String str){
        int count = 0;
        for(String s: str.split(" ")){
            if(s.length() >= 3 && s.contains("xox")){
                count += getCount(s);
            }
        }

    return count;
    }

    private  int getCount(String s) {
        int count = 0;
        int prev_count = 0;
        for(int i=0; i < s.length() - 2; ){
            String temp = s.substring(i, i + 3);
            System.out.printf("Substring is %4s\n",temp);
            if("xox".equals(temp)){
                i = i + 2;
                count = count == 0 ? 3 : count + 2;
            }else{
                i = i+1;
                prev_count = prev_count + count;
                count = 0;
            }
        }

        return prev_count + count;
    }
}