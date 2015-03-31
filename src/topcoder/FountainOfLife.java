package topcoder;

import java.util.TreeMap;

/**
 * Created by jalpanranderi on 10/25/14.
 */
public class FountainOfLife{


    public static void main(String[] args) {
        new FountainOfLife().elixirOfDeath(1, 2, 2);

        String s = "asd";

    }

    public double elixirOfDeath(int elixir, int poison, int pool){
        if(elixir > poison){
            return -1;
        }else{
            int sec = 0;

            double per_poison = 0;

            int total_poison = 0;
            int total_elixir = pool;

            while(per_poison <= 0.50){

                total_poison += poison;
                total_elixir += elixir;
                pool = total_poison + total_elixir;
                sec = sec + 1;

                per_poison = (double) total_poison /(double) pool;

                System.out.printf("elixir %6d  poison %6d  pool %6d  percetage %9f\n",total_elixir, total_poison, pool, per_poison);
            }

            return sec;

        }
    }
}