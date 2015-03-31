package cracking_code.arrays;

import java.util.Arrays;

/**
 * Created by jalpanranderi on 11/1/14.
 */
public class RotateMatrix {
    public static void main(String[] args) {

        int[][] mat = {{1,2,3},
                       {4,5,6},
                       {7,8,9}};

        print(rotate(mat));

    }


    private static void print(int[][] mat){
        for(int[] row: mat){
            System.out.println(Arrays.toString(row));
        }
    }


    private static int[][] rotate(int[][] mat){
       for(int layer = 0; layer < mat.length/2; layer++){
           int last = mat.length - layer - 1;

           for(int cell = layer; cell < last; cell++){
               int offset = cell - layer;

               int top = mat[layer][cell];

               // left -> top
               mat[layer][cell] = mat[last - offset][layer];

               // bottom -> left
               mat[last - offset][layer] = mat[last][last - offset];

               // right -> bottom
               mat[last][last- offset] = mat[cell][last];

               mat[cell][last] = top;
           }
       }
       return mat;
    }
}
