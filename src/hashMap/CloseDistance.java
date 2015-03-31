package hashMap;


import java.util.HashMap;

/**
 * Created by jalpanranderi on 10/19/14.
 */
public class CloseDistance {
    public static void main(String[] args) {
        String[] words = "All work and no play makes for no work no fun and no results".split(" ");

        System.out.printf("Closes distance is %d.\n",getClosesDistance(words));
    }


    private static int getClosesDistance(String[] words){
        HashMap<String, Integer> stringToDistance = new HashMap<>();
        int closesDistance = Integer.MAX_VALUE;

        for(int i=0; i < words.length; i++ ){
            if(stringToDistance.containsKey(words[i])){
                int previousDistance = stringToDistance.get(words[i]);

                stringToDistance.put(words[i],i);


                int distance = i - previousDistance;

                if(distance < closesDistance){
                    closesDistance = distance;
                }
            }else{
                stringToDistance.put(words[i], i);
            }
        }

        return closesDistance;
    }
}
