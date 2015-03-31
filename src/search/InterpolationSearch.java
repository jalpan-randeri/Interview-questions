package search;

/**
 * Knowledge of a binary search is assumed for this writeup.
 * Definition
 * <p/>
 * An interpolation search (also known as an extrapolation search or weighted binary search) is functionally
 * identical to a binary search except in one key feature: which element is checked. While a binary search always
 * checks the middle element of a vector, an interpolation search estimates where the sought value will lie. All
 * other aspects of a binary search apply: the search requires a sorted list, elements that cannot possibly be the
 * sought value are eliminated, and so on.To find the proper element to check, a very basic knowledge of Algebra is
 * necessary.
 * <p/>
 * Derivation
 * <p/>
 * The first step is to set up the equation of a line in slope-intercept form,
 *
 * y = mx + b
 *
 * This line will only be a segment drawn from the point (0, V[0]) to (size, V[size]) where size is the number of
 * elements in vector V minus one. Using the definition of slope,
 *
 * y = (V[size] - V[0]) / (size - 0) * x + b
 *
 * b is the y-intercept. Since the segment includes (and ends on) point (0, V[0]) we know that is the y-intercept.
 *
 * y = (V[size] - V[0]) / (size - 0) * x + V[0]
 *
 * Since the equation needs to be solved for x =, one final step is needed,
 *
 * x = ((y - V[0]) * (size - 0)) / (V[size] - V[0])
 *
 * <p/>
 * When searching to see if a particular value is in the vector, just plug the appropriate values into the equation
 * (with y equal to the sought value). Solving for x should yield which element in the vector is closest to y,
 * if all of the vector's elements lie on a line. Unfortunately, this is usually untrue,
 * so the algorithm is not O(1). However, this still implies that if you've got data that is (nearly) linear,
 * then perhaps an interpolation search is what you seek. Conversely, if you cannot foresee what kind of data you
 * will have, then use a binary search.
 * <p/>
 * Implementation
 * <pre>
 * 01  int InterpolationSearch(vector<int> V, int sought){
 * 02    int low, high, last, element;
 * 03    last = V.size() - 1;
 * 04    low = V[0];
 * 05    high = V[last];
 * 06    element = V[0];
 *
 * 07    while (low <= high){
 * 08      if (sought < low || sought > high)
 * 09        break;
 * 10      if (low == high)
 * 11        break;
 * 12      element = ((sought - low) * last) / (high - low);
 * 13      if (V[element] == sought)
 * 14        break;
 * 15      else if (V[element] > sought)
 * 16        low = V[element];
 * 17      else if (V[element] < sought)
 * 18        high = V[element];
 *        }
 *
 * 19    if (V[element] == sought)
 * 20      return element;
 * 21    else
 * 22      return -1;
 *     }
 * </pre>
 * Explanation
 * <p/>
 * In line 8, one knows that, because "V" is sorted, if "sought" is less than the least element or greater than the
 * greatest element that it exists nowhere in the array. Using that knowledge, one can then say, as in line 10,
 * that if "low" is equal to "high", that "sought" not only exists in "V", but every element in the "V" is equal to
 * "sought". Such a special case needs to be made because if line 12 is reached where "low == high" is true,
 * then the line will result in a division by zero error. Line 12 is simply the equation derived above with the
 * appropriate values used. Also note that the division in line 12 is integer division,
 * meaning decimal values are truncated downward (chop off everything after the decimal point, inclusive).
 * <p/>
 * Example
 * <p/>
 * When searching in a dictionary or a phone book, one often uses an interpolation search. Say you were searching in
 * a paper dictionary for the word epulosity. You might open up the dictionary a third of the way and come across the
 * word frisson. You immediately know every entry after frisson is invalid. So you flip back a few pages to
 * exasperate. Again, every entry after exasperate is invalid. Flipping back a few more pages you come upon epitome
 * so your search is just about done. Finding epulosity is trivial from there.
 * <p/>
 * Of course, because you don't know how many words there are in the dictionary and how many words are on each page,
 * it's not exactly an interpolation search. However, it's close enough for the purposes of an example. Finally,
 * an interpolation search is more natural, and is often quicker, than a binary search in such cases.
 *
 * Complexity: Best case : O(log(log n))
 *             Worst case: O(n)  behaves just like sequential search
 *
 *
 * Application: When search space is sorted and each key is uniformly distributed then interpolation search will be
 *              perform better than binary search. just like Telephone directory search.
 *
 */
public class InterpolationSearch {

    public static void main(String[] args) {

        int[] arr = {201, 209, 232, 233, 332, 399, 400};

        System.out.printf("Search result is %2d \n", interpolationSearch(arr, 201));
        System.out.printf("Search result is %2d \n", interpolationSearch(arr, 209));
        System.out.printf("Search result is %2d \n", interpolationSearch(arr, 232));
        System.out.printf("Search result is %2d \n", interpolationSearch(arr, 233));
        System.out.printf("Search result is %2d \n", interpolationSearch(arr, 332));
        System.out.printf("Search result is %2d \n", interpolationSearch(arr, 399));
        System.out.printf("Search result is %2d \n", interpolationSearch(arr, 400));

        System.out.printf("Search result is %2d \n", interpolationSearch(arr, 202));
        System.out.printf("Search result is %2d \n", interpolationSearch(arr, 2));
        System.out.printf("Search result is %2d \n", interpolationSearch(arr, 502));
    }


//    private static int interpolationSearch(int[] array, int key) {
//
//        int l = 0;
//        int r = array.length - 1;
//
//        while (l < r) {
//
//            if (array[l] == array[r]) {
//                if (array[l] == key) {
//                    return l;
//                } else {
//                    return -1;
//                }
//            }
//
//            int k = (key - array[l]) / (array[r] - array[l]);
//
//            if (k < 0 || k > 1) {
//                return -1;
//            }
//
//            int mid = Math.round(l + k * (r - l));
//
//            if (key < array[mid]) {
//                r = mid - 1;
//            } else if (key > array[mid]) {
//                l = mid + 1;
//            } else {
//                return mid;
//            }
//
//        }
//    return -1;
//    }


    private static int interpolationSearch(int[] array, int key) {

        int left = 0;
        int right = array.length - 1;
        int low = array[left];
        int high = array[right];

        if (key < low) {
            return -1;
        }

        if (key >= high) {
            left = right;
        }

        while (left < right) {
            //  y = m * x + c
            //  y -  c  = m * x
            //  ( y - c ) * (1 / m ) = x
            //  x = (y - c) * ( 1 / m)
            //  x = (k - 0) * ( 1 / (y2 - y1) / (x2 - x1))
            //  x = (k - 0) * ( x2 - x1) / (y2 - y1)
            //  x =  0 + (size)        *  (y - v[0])  / v[size] - v[0]
            int k = left + (right - left) * (key - low) / (high - low);
            int mid = array[k + 1];

            if (key < mid) {
                right = k;
                high = mid;
            } else {
                left = k + 1;
                low = mid;
            }
        }

        return (key == array[left]) ? left : -1;
    }


//    private static int interpolationSearch(int[] arr, int key){
//        return interpolationSearchHelper(arr, key, 0, arr.length - 1);
//    }
//
//    private static int interpolationSearchHelper(int[] arr, int key, int low, int high) {
//        if(low > high){
//            return -1;
//        }
//
//        if(arr[low] == arr[high] && arr[low] == key) {
//                return low;
//        }
//
//        int k = (key - arr[low]) / (arr[high] - arr[low]);
//
//        if(k < 0 || k > 1){
//            // not found
//            return -1;
//        }
//
//        int mid = Math.round(low + k * (high - low));
//
//        if(key < arr[mid]){
//            return interpolationSearchHelper(arr, key, low, mid - 1);
//        }else if(key > arr[mid]){
//            return interpolationSearchHelper(arr, key, mid + 1, high);
//        }else{
//            return  mid;
//        }
//    }


}
