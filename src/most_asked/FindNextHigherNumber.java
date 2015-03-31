package most_asked;

import java.io.IOException;

/**
 * Created by jalpanranderi on 11/7/14.
 */
public class FindNextHigherNumber {
    public static void main(String[] args) throws IOException {
        System.out.println(findNextHigher(12345));
        System.out.println(findNextHigher(12543));

        System.out.println(findNextHigher(136442));
        System.out.println("13621 : "+findNextHigher(13621));
    }


    private static int findNextHigher(int no) {
        return findNextHigherNumber(String.valueOf(no).toCharArray());
    }


    // time  = O(n + k + k log k)  = O(n)
    private static int findNextHigherNumber(char[] no) {

        // O(n)

        // find the pivot position
        int pivot = no.length - 1;
        for (int i = no.length - 2; i >= 0; i--) {
            if (no[i] >= no[i + 1]) {
                continue;
            } else {
                pivot = i;
                break;
            }
        }

        // O(k)

        // find swap position in region (pivot + 1, length)
        int min = Integer.MAX_VALUE;
        int min_ptr = pivot;
        for (int i = pivot + 1; i < no.length; i++) {
            if (no[i] < min) {
                min = no[i];
                min_ptr = i;
            }
        }

        char temp = no[min_ptr];
        no[min_ptr] = no[pivot];
        no[pivot] = temp;

        // O(k log k)


        // reverse pivot + 1 to length - 1 position
        for(int i=pivot + 1, j = no.length - 2; i < j; i++, j--){
            temp = no[i];
            no[i] = no[j];
            no[j] = temp;
        }

        return Integer.valueOf(String.valueOf(no));
    }
}
