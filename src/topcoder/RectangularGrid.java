package topcoder;

/**
 * Created by jalpanranderi on 10/30/14.
 */
public class RectangularGrid{

    public static void main(String[] args) {
        System.out.println(countRectangles(2,1));
        System.out.println(countRectangles(3,2));
        System.out.println(countRectangles(3,3));
    }

    public static  long countRectangles(int width, int height){

        return width >= height ? getCount(width,height) : getCount(height, width);
    }

    private static long getCount(int width, int height){
        return (width * (width+1) * (3 * height * (height-1) + 2 * (width - 1 ) ) ) / 12;
    }

}
