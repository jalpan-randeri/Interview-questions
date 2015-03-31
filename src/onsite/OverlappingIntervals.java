package onsite;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jalpanranderi on 12/4/14.
 */
public class OverlappingIntervals {
    public static void main(String[] args) {
        Interval[] set = {new Interval(1, 3),
                new Interval(2, 4),
                new Interval(6, 9),
                new Interval(2, 3),
                new Interval(1, 2),
                new Interval(4, 9),
                new Interval(5, 10),
                new Interval(3, 8),
                new Interval(10, 19),
                new Interval(21, 91),
                new Interval(22, 80),
        };

        System.out.println(getMaxOverlappingIntervals(set));
    }


    public static int getMaxOverlappingIntervals(Interval[] set) {
        Arrays.sort(set, new Comparator<Interval>() {
            @Override
            public int compare(Interval lhs, Interval rhs) {
                return lhs.start - rhs.start;
            }
        });

        System.out.println(Arrays.toString(set));

        int count = 0;
        int max = 0;
        Queue<Integer> started = new LinkedList<>();

        for (int i = 0; i < set.length; ) {
            if (started.isEmpty()) {
                started.add(set[i].end);
                count++;
                max = Math.max(count, max);
                i++;
            } else if (set[i].start < started.peek()) {
                count++;
                max = Math.max(count, max);
                started.add(set[i].end);
                i++;
            } else {
                started.remove();
                count--;
            }
        }

        return max;
    }


    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "("+start+", "+end+")";
        }
    }
}
