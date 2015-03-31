package most_asked;

/**
 *
 * There is an array of non-negative integers. A second array is formed by shuffling the elements of the first array
 * and deleting a random element. Given these two arrays, find which element is missing in the second array.
 * - See more at: http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.BgLHYvZ6.dpuf
 *
 * Created by jalpanranderi on 11/5/14.
 */
public class FindingMissingElement {

    public static void main(String[] args) {

        int[] org =     {4, 1, 0, 2, 9, 6, 8, 7, 5, 3};
        int[] shuffle = {6, 4, 7, 2, 1, 0, 8, 3 ,9};

        // answer is 5

        System.out.println(getMissingElement(shuffle, org));
    }

    // time  = O(n)
    // space = O(1)
    private static int getMissingElement(int[] shuffle, int[] org){
        int orgBitPattern = 0;
        int suffleBitPattern = 0;

        for(int o : org){
            orgBitPattern = orgBitPattern ^ o;
        }

        for(int s : shuffle){
            suffleBitPattern = suffleBitPattern ^ s;
        }

        return suffleBitPattern ^ orgBitPattern;
    }
}
