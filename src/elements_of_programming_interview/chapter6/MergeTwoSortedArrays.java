package elements_of_programming_interview.chapter6;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

/**
 * Created by jalpanranderi on 11/19/14.
 */
public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        char[] a = {'a', 'b', 'd', 'g','\0', '\0','\0','\0' };
        char[] b = {'c','e', 'f', 'h'};

        merge(a,b);

        System.out.println(Arrays.toString(a));

    }



    public static void merge(char[] a, char[] b){
        int ptr_a = 0;
        int ptr_b = b.length - 1;


        while(a[ptr_a] != '\0'){
            ptr_a++;
        }

        ptr_a = ptr_a - 1;


        int i = a.length - 1;

        for(; ptr_a >= 0 && ptr_b >= 0; i--){

            if(a[ptr_a] > b[ptr_b]){
                a[i] = a[ptr_a];
                ptr_a = ptr_a - 1;
            }else{
                a[i] = b[ptr_b];
                ptr_b = ptr_b - 1;
            }

        }

        i = i + 1;

        while(ptr_b >= 0){
            a[i] = b[ptr_b--];
            i = i - 1;
        }

    }

}
