package topcoder;

import java.util.Arrays;

/**
 * Created by jalpanranderi on 10/26/14.
 */
public class NameSort{

    public static void main(String[] args) {

        String[] list = {"tIm JoNeS", "Tim Jones", "tom JoNes", "tim joness", "tiM joneS"};

        new NameSort().newList(list);
    }


    public String[] newList(String[] list){
        for(int i=0; i<list.length; i++){

            System.out.println("itration "+i+" "+Arrays.toString(list));

            for(int j= i + 1; j<list.length; j++){
//                if(list[i].compareTo(list[j]) > 0){
                if(compare(list[i], list[j], i , j ) > 0){
                    String temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(list));

        return list;
    }


    private int compare(String src, String target, int src_index, int tar_index){
        String[] src_parts = src.split(" ");
        String[] tar_parts = target.split(" ");

        if(src_parts[src_parts.length - 1].equals(tar_parts[tar_parts.length - 1])){
            return tar_index - src_index;
        }else{
            return src.compareTo(target);
        }
    }

}