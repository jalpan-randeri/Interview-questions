package topcoder;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by jalpanranderi on 10/22/14.
 */
public class Checker{


    public static void main(String[] args) {
        Checker c = new Checker();


        String pos = "4,1";
        String[] pieces = {"2,4", "3,4", "4,4", "5,4", "2,6", "3,6", "4,6", "5,6"};
        System.out.println("answer is "+c.compute(pos, pieces));
    }

    private static final int LENGTH_BOARD = 8;
    private static final int MIN_EDGE = 0;

    public int compute(String startPos, String[] pieces){
        int x = getX(startPos);
        int y = getY(startPos);

        char[][] board = new char[8][8];
        for(String  block : pieces){
            int col = getX(block);
            int row = getY(block);


            board[7 - row][col] = 'B';
        }

        print(board);

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x,y});
        int step = 0;

        while(!stack.isEmpty()){

            int[] nextPlace = stack.pop();
            x = nextPlace[0];
            y = nextPlace[1];

            if(isWon(y)){
                return step;
            }else{
                int[][] possibleMoves = getNextMoves(x,y, board);

                print(possibleMoves);

                if(possibleMoves != null) {
                    for (int[] move : possibleMoves) {
                        if (move != null) {
                            stack.push(move);
                        }
                    }
                }
            }

            step++;
        }

        return -1;

    }

    private void print(char[][] board) {
        int count = 7;
        System.out.print(" ");
        for(int i=0; i<8; i++){
            System.out.printf("%2d",i);
        }

        System.out.println();

        for(char[] row : board){
            System.out.printf("%d",count--);
            for(char c: row) {
                System.out.printf("%2c",c);
            }
            System.out.println();
        }
    }

    private void print(int[][] board) {
        for(int[] row : board){
            System.out.println(Arrays.toString(row));
        }
    }

    private int[][] getNextMoves(int x, int y, char[][] board){
        int[][] possibleMoves = new int[2][2];
        possibleMoves[0] = getRight(x, y, board);
        possibleMoves[1] = getLeft(x, y, board);

        if(possibleMoves[0] == null  || possibleMoves[1] == null){
            return null;
        }
        return possibleMoves;
    }

    private boolean isWon(int y){
        return y == MIN_EDGE;
    }


    private int[] getRight(int x, int y, char[][] board){

        if(x+1 < LENGTH_BOARD && y - 1 < LENGTH_BOARD && board[x+1][y-1] != 'B'){
            return new int[]{x+1, y-1};
        }else if(x+2 < LENGTH_BOARD && y-2 < LENGTH_BOARD && board[x+2][y-2] != 'B'){
            return new int[] {x+2, y-2};
        }

        return null;
    }


    private int[] getLeft(int x, int y, char[][] board){

        if(x - 1 >= MIN_EDGE && y - 1 >= MIN_EDGE && board[x - 1][y - 1] != 'B'){
            return new int[]{x - 1 ,y - 1};
        }else if(x - 2 > MIN_EDGE && y - 2 > MIN_EDGE && board[x - 2][y - 2] != 'B'){
            return new int[] {x - 2, y - 2};
        }

        return null;
    }


    private int getX(String s){
        return s.charAt(0) - '0';
    }

    private int getY(String s){
        return s.charAt(2) - '0';
    }



}