package cracking_code.arrays;

import java.util.Arrays;

/**
 * Created by jalpanranderi on 11/1/14.
 */
public class ArrayPartition {

    public static void main(String[] args) {
        int data[] = {1,4,3,2,1,1,1,1,1,8,9,10,11};

        System.out.println(Arrays.toString(partitionInPlace(data, 7)));

        data = new int[] {8, 6, 4, 7, 9, 5, 1, 2, 15, 20, 6};
        System.out.println(Arrays.toString(partitionInPlace(data, 9)));
    }


    // smaller =  0 - (equal-1)
    // equal =
    // large = equal - (size - 1)
    // unspecified = equal - large
    private static int[] partitionInPlace(int[] data, int i){

        int smaller = 0;
        int equal = 0;
        int large = data.length -1;

        while(equal <= large){

            if(data[equal] < i){
                // current is less than key
                // swap with equal position
                int temp = data[equal];
                data[equal] = data[smaller];
                data[smaller] = temp;

                smaller++;
                equal++;
            }else if(data[equal] == i){
                equal++;
            }else{
                // greater than key
                int temp = data[equal];
                data[equal] = data[large];
                data[large] = temp;

                large--;
            }
        }

        return data;
    }
}
