import java.util.Arrays;
import java.util.Random;

/**
 * Created by jalpanranderi on 11/26/14.
 */
public class CommonInTwoArrays {
    public static void main(String[] args) {
        int[] a = new int[100];
        int[] b = new int[100];

        Random r = new Random();

        for(int i = 0; i < a.length; i++){
            a[i] = (r.nextInt() % 100) + 1;
            b[i] = (r.nextInt() % 100) + 1;
        }

        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        commonElements(a, b);
    }

    public static void commonElements(int[] a, int[] b){
        int ptr_a = 0;
        int ptr_b = 0;

        while(ptr_a < a.length && ptr_b < b.length){
            if(a[ptr_a] == b[ptr_b]){
                // intersection occurs
                System.out.printf("%4d",a[ptr_a]);
                ptr_a++;
                ptr_b++;
            }else if(a[ptr_a] > b[ptr_b]){
                ptr_b++;
            }else{
                ptr_a++;
            }
        }

    }
}
