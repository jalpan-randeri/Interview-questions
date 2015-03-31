package topcoder;

import java.util.Arrays;

/**
 * Created by jalpanranderi on 10/22/14.
 */
public class DiskSpace{

    public static void main(String[] args) {

        int[] used = {300,525,110};
        int[] total = {350,600,115};

        DiskSpace d = new DiskSpace();
        System.out.println("ans is "+d.minDrives(used, total));
    }

    public int minDrives(int[] used, int[] total){
        int occupied = 0;
        for(int u : used){
            occupied += u;
        }

        Arrays.sort(total);

        int count = total.length - 1;
        int answer = 0;
        while(occupied > 0){
            occupied = occupied - total[count];
            System.out.println(occupied);
            count--;
            answer++;
        }
        return answer;
    }

}