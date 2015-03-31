package most_asked;

import java.util.Arrays;

/**
 * Given an array [a1, a2, ..., aN, b1, b2, ..., bN, c1, c2, ..., cN]  convert it to [a1, b1, c1, a2, b2, c2, ...,
 * aN, bN, cN] in-place using constant extra space
 *
 * - See more at: http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.BgLHYvZ6.dpuf
 * Created by jalpanranderi on 11/6/14.
 */
public class ConvertArray {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {4,5,6};
        int[] c = {7,8,9};

        int[] data = {1,4,7,2,5,8,3,6,9};

        System.out.println(Arrays.toString(convert(data,0,3,6)));

    }



    private static int[] convert(int[] data, int ptr_a, int ptr_b, int ptr_c){
        int a_next;
        int a_next_next;
        int temp;
        ptr_a++;
        for(;ptr_c < data.length;){
            a_next = data[ptr_a];
            temp = a_next;

            data[ptr_a] = data[ptr_b];
            data[ptr_a++] = data[ptr_c];

            ptr_a++;
            ptr_b++;
            ptr_c++;
        }

        return data;
    }
}
