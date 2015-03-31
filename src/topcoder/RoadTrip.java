package topcoder;

import java.util.HashMap;

/**
 * Created by jalpanranderi on 10/26/14.
 */
public class RoadTrip{

    private static final char TURN_LEFT = 'L';
    private static final char TURN_RIGHT = 'R';
    private static final char TURN_AROUND = 'B';

    private static final char FACE_UP = 'U';
    private static final char FACE_DOWN = 'D';
    private static final char FACE_LEFT = 'L';
    private static final char FACE_RIGHT = 'R';


    public static void main(String[] args) {

        String[] map = {".R....B",
                        ".......",
                        ".......",
                        ".L....L",
                        ".......",
                        "......."};

        new RoadTrip().howMany(map);


//        System.out.println("turn left "+turn(FACE_LEFT, TURN_LEFT)); // down
//        System.out.println("turn left "+turn(FACE_LEFT, TURN_RIGHT));  // up
//        System.out.println("turn left "+turn(FACE_LEFT, TURN_AROUND)); // right
//
//        System.out.println("turn left "+turn(FACE_RIGHT, TURN_LEFT)); // up
//        System.out.println("turn left "+turn(FACE_RIGHT, TURN_RIGHT));  // down
//        System.out.println("turn left "+turn(FACE_RIGHT, TURN_AROUND)); // left

//        System.out.println("turn left "+turn(FACE_UP, TURN_LEFT)); // left
//        System.out.println("turn left "+turn(FACE_UP, TURN_RIGHT));  // right
//        System.out.println("turn left "+turn(FACE_UP, TURN_AROUND)); // down

//        System.out.println("turn left "+turn(FACE_DOWN, TURN_LEFT)); // right
//        System.out.println("turn left "+turn(FACE_DOWN, TURN_RIGHT));  // left
//        System.out.println("turn left "+turn(FACE_DOWN, TURN_AROUND)); // up


//        System.out.println("move "+moveNextCol(FACE_DOWN,0)); // 0
//        System.out.println("move "+moveNextCol(FACE_UP,0)); // 0
//        System.out.println("move "+moveNextCol(FACE_RIGHT,0)); // 1
//        System.out.println("move "+moveNextCol(FACE_LEFT,0)); // -1

//        System.out.println("move "+moveNextRow(FACE_DOWN,0));  // 1
//        System.out.println("move "+moveNextRow(FACE_UP,0));    // -1
//        System.out.println("move "+moveNextRow(FACE_RIGHT,0)); // 0
//        System.out.println("move "+moveNextRow(FACE_LEFT,0));  // 0

    }


    public int howMany(String[] map){
        char[][] board = new char[map.length][map[0].length()];

        for(int i=0; i<map.length; i++){
            board[i] = map[i].toCharArray();
        }


        return moveCar(board);
    }


    private int moveCar(char[][] map){
        int step = 0;

        int row = 0;
        int col = 1;
        char curr_face = FACE_RIGHT;

        boolean[][] tracker = new boolean[map.length][map[0].length];


        while(true){
            System.out.printf("face %2c row : %2d col : %2d\n", curr_face, row, col);



            if(row < 0 || row >= map.length || col < 0 || col >= map[0].length){
                System.out.println("total steps are "+step);
                return step;
            }

            if(map[row][col] == TURN_LEFT){
                curr_face = turn(curr_face, TURN_LEFT);
            }else if(map[row][col] == TURN_RIGHT){
                curr_face = turn(curr_face, TURN_RIGHT);
            }else if(map[row][col] == TURN_AROUND){
                curr_face = turn(curr_face, TURN_AROUND);
            }

            if(!tracker[row][col]) {
                step++;
                tracker[row][col] = true;
            }

            row = moveNextRow(curr_face, row);
            col = moveNextCol(curr_face, col);



        }
    }

    private static int moveNextRow(char face, int row){
        switch(face){
            case FACE_LEFT:    // fall through
            case FACE_RIGHT:   return row;
            case FACE_UP:   return row - 1;
            case FACE_DOWN:  return row + 1;
        }

        return -1;
    }


    private static int moveNextCol(char face, int col){
        switch(face){
            case FACE_LEFT:  return col - 1;
            case FACE_RIGHT: return col + 1;
            case FACE_UP:   // fall through
            case FACE_DOWN:  return col;
        }
        return -1;
    }

    private static char turn(char face, char turn){
        switch(turn){
            case TURN_LEFT: return turnLeft(face);
            case TURN_RIGHT: return turnRight(face);
            case TURN_AROUND: return turnAround(face);
        }

        return '\0';
    }

    private static char turnLeft(char face){
        switch(face){
            case FACE_UP:   return FACE_LEFT;
            case FACE_DOWN:  return FACE_RIGHT;
            case FACE_LEFT:  return FACE_DOWN;
            case FACE_RIGHT: return FACE_UP;
        }
        return '\0';
    }

    private static char turnRight(char face){
        switch(face){
            case FACE_UP:  return FACE_RIGHT;
            case FACE_DOWN:  return FACE_LEFT;
            case FACE_LEFT:  return FACE_UP;
            case FACE_RIGHT: return FACE_DOWN;
        }
        return '\0';
    }

    private static char turnAround(char face){
        switch(face){
            case FACE_UP: return FACE_DOWN;
            case FACE_LEFT: return FACE_RIGHT;
            case FACE_DOWN: return FACE_UP;
            case FACE_RIGHT: return FACE_LEFT;
        }
        return '\0';
    }
}
