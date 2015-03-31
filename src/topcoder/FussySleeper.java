package topcoder;

/**
 * Created by jalpanranderi on 10/25/14.
 */
public class FussySleeper{
    public int[] nextTime(int[] currentTime, int elephants){
        int time = currentTime[0] * 100 + currentTime[1];

        if(time % elephants == 0){
            time = time + elephants;
        }else{
            int next = elephants - (time % elephants);
            time = time + next;
        }

        int hr = time / 100;
        int min = time - hr * 100;
        if(min > 59){
            hr++;
            min = min - 59;
        }

        if(hr > 23){
            hr = hr - 23;
        }

        return  new int[]{hr, min};
    }

}