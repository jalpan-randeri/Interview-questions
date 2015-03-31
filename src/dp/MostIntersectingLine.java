package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO:  Implemente this with complexity (n Log n)
 *
 * Created by jalpanranderi on 11/9/14.
 */
public class MostIntersectingLine {
    public static void main(String[] args) {
        Line[] set = {new Line(1,4), new Line(-1,6), new Line(8,50), new Line(30,60) };

        System.out.println(Arrays.toString(sortSet(set)));

        System.out.println("Most Intersection at line "+getIntersectingLineCount(set).x2);

    }

    private static Line[] sortSet(Line[] set){
        for(int i=0; i< set.length; i++){
            for(int j=0; j < set.length; j++){
                if(set[i].x1 < set[j].x1){
                    Line temp = set[i];
                    set[i] = set[j];
                    set[j] = temp;
                }
            }
        }

        return set;
    }


    public static Line getIntersectingLineCount(Line[] set){
        set = sortSet(set);  // n log n
        int count = Integer.MIN_VALUE;
        int temp = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        for(int i = 0; i < set.length; i++){
            temp = getTotalIntersectingLineCount(set[i], set, 0, set.length - 1, i);
            System.out.println("Temp is "+temp);
            if(temp > count){
                count = temp;
                y = set[i].x1;
            }
        }


        return new Line(count, y);
    }

    private static int getTotalIntersectingLineCount(Line l, Line[] set, int start, int end, int lineIndex) {
        if(start > end){
            return 0;
        }else{
            int mid = start + end >> 1;
            if(set[mid].x1 == l.x2){
                return mid - lineIndex;
            }

            if(l.x2 < set[mid].x1){
                return getTotalIntersectingLineCount(l, set, start, mid - 1, lineIndex);
            }else{
                return getTotalIntersectingLineCount(l, set, mid + 1, end, lineIndex);
            }

        }

    }


    private static boolean isIntersect(Line line1, Line line2) {
        return line1.x2 > line2.x1 && line2.x2 > line1.x1;
    }


    public static class Line{
        int x1;
        int x2;
        int y;

        public Line(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }

        @Override
        public String toString() {
            return "{" + x1 +"," + x2 +"}";
        }
    }
}
