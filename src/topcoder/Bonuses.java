package topcoder;

import java.util.Arrays;

/**
 * Created by jalpanranderi on 10/29/14.
 */
public class Bonuses {

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5};
        new Bonuses().getDivision(data);
    }


    public int[] getDivision(int[] points){
        int total = 0;
        for(int p : points){
            total += p;
        }

        int sum = 0;


        int[] div = new int[points.length];

        int max_place = -1;

        for(int i = 0; i<points.length; i++){

            if(points[i] > max_place){
                max_place = i;
            }

            div[i] = getPercent(points[i], total);
            sum = sum + div[i];
        }

        int diff = 100 - sum;
        if(diff != 0){

            while(diff != 0){
                div[max_place] += 1;

            }
        }

        System.out.println(Arrays.toString(div));
        return div;
    }

    private int getPercent(int i, int total){
        return (int) (i * 100/ total);
    }
}
