package topcoder;

import java.util.Arrays;

/**
 * Created by jalpanranderi on 10/26/14.
 */
public class CityBuses {

    public static void main(String[] args) {
        String[] data = {"--B",
                "---",
                "-B-"};


        System.out.println(new CityBuses().maximumFare(data));
    }


    public int maximumFare(String[] blocks) {

        int[] maxPoint = {-1, -1};
        int[] minPoint = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        for (int i = 0; i < blocks.length; i++) {
            char[] block = blocks[i].toCharArray();
            for (int j = 0; j < block.length; j++) {
                if (block[j] == 'B') {
                    if (minPoint[0] > i && minPoint[1] > j) {
                        minPoint[0] = i;
                        minPoint[1] = j;
                    }

                    if (maxPoint[0] < i && maxPoint[1] < j) {
                        maxPoint[0] = i;
                        maxPoint[1] = j;
                    }
                }
            }




        }

        System.out.println(" min " + Arrays.toString(minPoint) + " max " + Arrays.toString(maxPoint));

            return (Math.abs(minPoint[0] - maxPoint[0]) + Math.abs(minPoint[1] - maxPoint[1]));
    }
}
