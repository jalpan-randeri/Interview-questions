package last_minute;

import java.util.HashMap;

/**
 * Created by jalpanranderi on 11/24/14.
 */
public class WordBraker {

    public static void main(String[] args) {

    }


    private static String wordBreaker(String ip, HashMap<String, String> dict, HashMap<String, String> dp){

        if(dp.containsKey(ip)){
            return ip;
        }

        if(dict.containsKey(ip)){
            return ip;
        }

        for(int i = 1; i < ip.length(); i++){
            String prefix = ip.substring(0, i);
            if(dict.containsKey(prefix)){
                String suffix = ip.substring(i + 1, ip.length() - 1);
                String ans = wordBreaker(suffix, dict, dp);
                if(ans != null){
                    return prefix + " " + suffix;
                }
            }
        }

        dp.put(ip, null);

        return null;
    }
}
