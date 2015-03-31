package topcoder;

/**
 * Created by jalpanranderi on 11/21/14.
 */
public class SimpleCardGame{

    public static void main(String[] args) {
        System.out.println(whoIsTheWinner(new int[]{1,2}));
    }

    public static int  whoIsTheWinner(int[] points){
        int winner = -1;
        boolean isDuplicate = false;
        int maxScore = Integer.MIN_VALUE;

        for(int i = 0; i < points.length; i++){
            int score = points[i] - 21;
            if( score <= 0){
                if(maxScore < score){
                    maxScore = score;
                    winner = i;
                    isDuplicate = false;
                }else if(maxScore == score){
                    isDuplicate = true;
                }
            }
        }

        return isDuplicate ? -1 : winner;
    }


}