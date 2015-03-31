package topcoder;

/**
 * Created by jalpanranderi on 11/6/14.
 */
public class BestHotel{

    public static void main(String[] args) {

        int[] p = {200,300,100,500,100,100,200};
        int[] q ={7,7,4,8,4,3,6};

        System.out.println(numberOfDisadvantageous(p,q));

    }

    public static int numberOfDisadvantageous(int[] prize, int[] quality){
        int count = 0;
        int low_prize = prize[0];
        int bet_quality = quality[0];

        for(int i=1; i< prize.length; i++){
            if(bet_quality <= quality[i] && low_prize >= prize[i]){
                bet_quality = quality[i];
                low_prize = prize[i];
            }
        }

        for(int i=0; i<prize.length; i++){
            if(isWorst(bet_quality, low_prize,prize[i], quality[i])){
                count++;
            }
        }


        return count;
    }


    private static boolean isWorst(int bestQ, int bestP, int prize, int quality){
        return quality < bestQ && prize >= bestP ||
               quality <= bestQ && prize > bestP;


    }

}