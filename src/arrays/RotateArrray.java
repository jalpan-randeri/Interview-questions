package arrays;

import java.util.Arrays;

/**
 * Created by jalpanranderi on 10/13/14.
 */
public class RotateArrray {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8};

        System.out.println("Arrays " + Arrays.toString(data)+" rotate after "+Arrays.toString(rotate(data, 1)));
        System.out.println("Arrays " + Arrays.toString(data)+" rotate after "+Arrays.toString(rotate(data, 2)));
        System.out.println("Arrays " + Arrays.toString(data)+" rotate after "+Arrays.toString(rotate(data, 3)));

        data = new int[]{1,2,3,4,5,6,7,8};
        System.out.println("Arrays " + Arrays.toString(data)+" rotate after "+Arrays.toString(rotateImprovedSpace(data, 1)));
        data = new int[]{1,2,3,4,5,6,7,8};
        System.out.println("Arrays " + Arrays.toString(data)+" rotate after "+Arrays.toString(rotateImprovedSpace(data, 2)));
        data = new int[]{1,2,3,4,5,6,7,8};
        System.out.println("Arrays " + Arrays.toString(data)+" rotate after "+Arrays.toString(rotateImprovedSpace(data, 3)));
    }


    // time  = O(n)
    // space = O(n)
    private static int[] rotate(int[] arr, int r){
        int[] answer = new int[arr.length];
        if(r <= 0){
            return arr;
        }else{
            int i=r;
            int j=0;
            for(; i < arr.length; i++, j++){
                answer[j] = arr[i];
            }

            for(i =0 ;j < answer.length; j++, i++){
                answer[j] = arr[i];
            }

            return answer;
        }
    }


    // time  = O(n * m)  where n is number or rotations and m is total elements
    // space = O(1)
    private static int[] rotateImprovedSpace(int[] arr, int r){
        while(r > 0){
            arr = rotateByOne(arr);
            r--;
        }
        return arr;
    }

    private static int[] rotateByOne(int[] data){
        int temp = data[0];

        for(int i = 0; i < data.length - 1; i++){
            data[i] = data[i + 1];
        }

        data[data.length - 1] = temp;
        return data;
    }
}
