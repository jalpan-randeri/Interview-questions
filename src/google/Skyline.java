package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jalpanranderi on 12/27/14.
 */
public class Skyline {
    public static void main(String[] args) {
        SkylinePoint[] skyline = {
                new SkylinePoint(1, 5, 11),
                new SkylinePoint(2, 7, 6),
                new SkylinePoint(3, 9, 13),
                new SkylinePoint(12, 16, 7),
                new SkylinePoint(14, 25, 3),
                new SkylinePoint(19, 22, 18),
                new SkylinePoint(23, 29, 13),
                new SkylinePoint(24, 28, 4)
        };


        List<SkylinePoint> ans = generateSkyline(skyline);
        System.out.println(ans);
    }

    public static List<SkylinePoint> generateSkyline(SkylinePoint[] skylines) {
        return generateSkylineHelper(skylines, 0, skylines.length);
    }

    private static List<SkylinePoint> generateSkylineHelper(SkylinePoint[] skylines, int start, int end) {

        if (end - start <= 1) {
            ArrayList<SkylinePoint> mergedSkyline = new ArrayList<>();
            mergedSkyline.add(skylines[start]);
            return mergedSkyline;
        }

        int mid = (start + end) / 2;

        List<SkylinePoint> leftSkyline = generateSkylineHelper(skylines, start, mid);
        List<SkylinePoint> rightSkyline = generateSkylineHelper(skylines, mid + 1, end);

        return mergeSkyline(leftSkyline, rightSkyline);


    }

    private static List<SkylinePoint> mergeSkyline(List<SkylinePoint> left, List<SkylinePoint> right) {
        List<SkylinePoint> ans = new ArrayList<>();
        int ptr_left = 0;
        int ptr_right = 0;

        while (ptr_left < left.size() && ptr_right < right.size()) {

            if (left.get(ptr_left).end < right.get(ptr_right).start) {
                // left building is not intersecting with right building
                ans.add(left.get(ptr_left));
                ptr_left++;

            } else if (right.get(ptr_right).end < left.get(ptr_left).start) {
                // right building is on left side of left building
                // hence not intersecting
                // add the right building to answer
                ans.add(right.get(ptr_right));
                ptr_right++;
            } else if (left.get(ptr_left).start <= right.get(ptr_right).start) {
                // left building and right building are intersecting on left
                // buildings end point
                int[] result = mergeIntersectingBuilding(ans, left, right, ptr_left, ptr_right);
                ptr_left = result[0];
                ptr_right = result[1];
            } else {
                // left building is intersecting on right buildings end point
                int[] result = mergeIntersectingBuilding(ans, right, left, ptr_left, ptr_right);
                ptr_left = result[0];
                ptr_right = result[1];
            }
        }


        // add remaining into ans
        while (ptr_left < left.size()) {
            ans.add(left.get(ptr_left));
            ptr_left++;
        }


        // add remaining into ans
        while (ptr_right < right.size()) {
            ans.add(right.get(ptr_right));
            ptr_right++;
        }

        return ans;
    }

    private static int[] mergeIntersectingBuilding(List<SkylinePoint> ans, List<SkylinePoint> left,
                                                   List<SkylinePoint> right, int ptr_left, int ptr_right) {

        if (left.get(ptr_left).end <= right.get(ptr_right).end) {
            if (left.get(ptr_left).height > right.get(ptr_right).height) {
                if (right.get(ptr_right).end != left.get(ptr_left).end) {
                    ans.add(left.get(ptr_left));

                    right.get(ptr_right).start = left.get(ptr_left).end;
                    ptr_left++;
                } else {
                    ptr_right++;
                }
            } else if (left.get(ptr_left).height == right.get(ptr_right).height) {
                right.get(ptr_right).start = left.get(ptr_left).start;
                ptr_left++;
            } else {
                if (left.get(ptr_left).start != right.get(ptr_right).start) {
                    ans.add(new SkylinePoint(left.get(ptr_left).start,
                            right.get(ptr_right).start,
                            left.get(ptr_left).height));
                }
                ptr_left++;
            }
        } else {
            // left.end > right.end
            if (left.get(ptr_left).height >= right.get(ptr_right).height) {
                ptr_right++;
            } else {
                if (left.get(ptr_left).start != right.get(ptr_right).start) {
                    ans.add(new SkylinePoint(left.get(ptr_left).start,
                            right.get(ptr_right).start,
                            left.get(ptr_left).height));
                }

                left.get(ptr_left).start = right.get(ptr_right).end;
                ans.add(right.get(ptr_right));
                ptr_right++;
            }
        }

        return new int[]{ptr_left, ptr_right};
    }


    private static class SkylinePoint {
        int start;
        int end;
        int height;

        public SkylinePoint(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
        }

        @Override
        public String toString() {
            return "{" +
                     + start +
                    ", " + end +
                    ", " + height +
                    "}";
        }
    }
}
