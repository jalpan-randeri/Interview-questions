package topcoder;

/**
 * Created by jalpanranderi on 10/22/14.
 */
public class Time{

    public String whatTime(int milli){
        // determine hr
        int hr = milli / (60 * 60);
        int min = hr * 100 - hr;
        min = min > 60 ? min / 60 : min;
        int sec = min * 100 - min;


        return String.format("%d:%d:%d",hr, min, sec);
    }

}
