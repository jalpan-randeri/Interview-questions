package string;

/**
 * Created by jalpanranderi on 9/22/14.
 */
public class StringMatch {


    private static final int MATCH = 0;
    private static final int DELETE = 1;
    private static final int SUBSTITUTE = 2;

    public static void main(String[] args) {


        System.out.println(editDistance("thou shalt not".toCharArray(), "you should not".toCharArray()));

        System.out.println();

        System.out.println(editDistance("jalpan".toCharArray(), "japan".toCharArray()));
    }



    private static int[][] mat;

    public static int editDistance(char[] data, char[] pattern){



        int MAX_LEN = Math.max(data.length, pattern.length);

        mat = new int[MAX_LEN + 1][MAX_LEN + 1];

        //init
        for(int i = 0; i <= MAX_LEN; i++){
            rowInit(i);
            colInit(i);
        }

        int cost[] = new int[3];

        for(int row = 1; row <= data.length; row++){
            for(int col = 1; col <= pattern.length; col ++){

                cost[MATCH] = mat[row-1][col-1] + match(data[row - 1], pattern[col - 1]);
                cost[DELETE] = mat[row][col-1] + delete();
                cost[SUBSTITUTE] = mat[row - 1][col] + insert();

                mat[row][col] = lowest(cost);

            }
        }


//        displayMatrix(mat);
        return mat[data.length][pattern.length];
    }

    private static int lowest(int[] cost) {
        return Math.min(cost[0], Math.min(cost[1], cost[2]));
    }

    private static void colInit(int i) {
        mat[i][0] = i;
    }

    private static void rowInit(int i) {
        mat[0][i] = i;
    }

    private static void displayMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int cell : row) {
                System.out.printf("%3d ", cell);
            }
            System.out.println("");
        }
    }




    private static int match(char c, char p){
        return c == p ? 0 : 1;
    }

    private static int delete(){
        return 1;
    }

    private static int insert(){
        return 1;
    }
}
