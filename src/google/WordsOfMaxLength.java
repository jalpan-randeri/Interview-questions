package google;

import java.util.*;

/**
 *
 * nput:
 words: ["abc", "acbb", "caab", "xyz"]
 letters: ['a' 'c', 'a', 'x', 'b', 'b', 'c']

 * Created by jalpanranderi on 11/23/14.
 */
public class WordsOfMaxLength {

    public static void main(String[] args) {
        String[] words = {"abc","acbb", "caab", "xyz"};

        HashMapImpl map = new HashMapImpl();
        for(String w : words){
            map.put(w);
        }

        List<String> list = map.get(0);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        System.out.println(list);




    }

    private static class HashMapImpl {
        List[] set = new List[2];

        public HashMapImpl() {
        }

        @SuppressWarnings("unchecked")
        public void put(String value){
            int key = 0;
            for(char c : value.toCharArray()){
                if(c == 'a' || c == 'c' || c == 'x' || c == 'b'){
                    key +=0;
                }else{
                    key = 1;
                }
            }

            ArrayList<String> list = (ArrayList<String>) set[key];
            if(list != null && !list.contains(value)){
                list.add(value);
                set[key] = list;
            }else if(list == null){
                set[key] = new ArrayList<>();
                set[key].add(value);
            }

        }


        public List get(int key){
            return set[key];
        }

    }


}
