package most_asked;

import java.util.HashMap;

/**
 *
 * Given a matrix of integers and coordinates of a rectangular region within the matrix,
 * find the sum of numbers falling inside the rectangle. Our program will be called multiple times with different
 * rectangular regions from the same matrix.
 *
 * - See more at: http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.BgLHYvZ6.dpuf
 *
 *
 * Created by jalpanranderi on 11/4/14.
 */
public class MatrixRegionSum {

    public static void main(String[] args) {

    }

    private static int compute(int[][] matrix, int row, int col){
        int sum = 0;
        for(int r = 0; r <= row; r++){
            for(int c = 0; c <= col; c++){
                sum += matrix[r][c];
            }
        }
        return sum;
    }


    private static void preprocess(int[][] martrix){

    }

    private static int computeNaive(int[][] matrix, int row, int col){

    return -1;
    }

//    public static class Position{
//        int row;
//        int col;
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (!(o instanceof Position)) return false;
//
//            Position position = (Position) o;
//
//            if (col != position.col) return false;
//            if (row != position.row) return false;
//
//            return true;
//        }
//
//        @Override
//        public int hashCode() {
//            int result = row;
//            result = 31 * result + col;
//            return result;
//        }
//    }
}
