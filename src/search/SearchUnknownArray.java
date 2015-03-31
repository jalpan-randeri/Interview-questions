package search;

/**
 * searching for i = A[i] element inside unknown size array
 *
 * Created by jalpanranderi on 10/17/14.
 */
public class SearchUnknownArray {
    public static void main(String[] args) {
        int[] data = {-10, 1, 203, 220, 234, 279, 368, 378, 478, 550, 631};
        System.out.printf("matching element is %2d\n",getElement(data));


        data = new int[]{2, 2, 3, 4, 5, 6, 7, 8, 8, 8, 631};
        System.out.printf("matching element is %2d\n",getElement(data));


        data = new int[]{-10, 1, 203, 220, 234, 279, 368, 378, 478, 550, 631};
        System.out.printf("matching element is %2d\n",getElement(data));
    }



    //
    private static int getElement(int[] data){
        int i = 0;

        while(true) {
            try {
                if (data[i] == i) {
                    return data[i];
                } else if (data[i] < i) {
                    i++;
                } else if (data[i] > i) {
                    int low = i;

                    i = data[i];

                    int high = i;
                    int mid = low + high >> 1;

                    while(low > high){
                        if(data[mid] == mid){
                            return mid;
                        }else if( mid > data[mid]){
                            low = mid + 1;
                        }else{
                            high = mid - 1;
                        }
                    }

                }
            } catch (ArrayIndexOutOfBoundsException noElement) {
                return -1;
            }
        }
    }
}
