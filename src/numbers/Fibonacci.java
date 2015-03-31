package numbers;

/**
 * Created by jalpanranderi on 10/13/14.
 */
public class Fibonacci {

    public static void main(String[] args) {

        System.out.printf("%2d fibonacci number is %15d\n",1,getFibonacci(1));
        System.out.printf("%2d fibonacci number is %15d\n",10,getFibonacci(10));
        System.out.printf("%2d fibonacci number is %15d\n",50,getFibonacci(50));


        System.out.printf("%2d fibonacci number is %15d\n",1,getFibonacciImproved(1));
        System.out.printf("%2d fibonacci number is %15d\n",10,getFibonacciImproved(10));
        System.out.printf("%2d fibonacci number is %15d\n",50,getFibonacciImproved(50));
    }


    private static int getFibonacci(int number){
        int a = 1;
        int b = 1;
        int answer = 1;
        if(number > b){

            for(int count = 0; count <= number; count++){
                answer = a + b;
                a = b;
                b = answer;
            }
        }

        return answer;
    }

    private  static  int[][] mat = {{1, 0}, {0, 1}};

    private static int getFibonacciImproved(int number){
        mat = new int[][] {{1, 0},{0, 1}};

//        printMatrix(mat);
        matpow(number - 1);

//        printMatrix(mat);
        return mat[0][0];
    }

    private static void matpow(int power){
        if(power > 1){
            matpow(power << 1);
            mat = multiply(mat, mat);

        }

        if(power % 2 != 0){
            mat = multiply(mat, new int[][]{{1,1},{1,0}});
        }

    }



//            [ a b ] [ d e ]   [ ad + be  bd + ce ]
//            [ b c ] [ e f ] = [ bd + ce  be + cf ]
    public static int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] ans = new int[2][2];

        int a = mat1[0][0];
        int b = mat1[0][1];
        int c = mat1[1][1];
        int d = mat2[0][0];
        int e = mat2[0][1];
        int f = mat2[1][1];

        ans[0][0] = a * d + b * e;
        ans[0][1] = b * d + c * e;
        ans[1][0] = b * d + c * e;
        ans[1][1] = b * e + c * f;

        return ans;
    }


    private static void printMatrix(int[][] mat){
        for(int[] row : mat){
            for(int col : row){
                System.out.printf("%4d",col);
            }
            System.out.println();
        }
    }
}
