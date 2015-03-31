package search;

/**
 * We know that it is a good practice to use a fixed size step. Actually when the step is 1,
 * the algorithm is the traditional sequential search. The question is what should be the length of the step and is
 * there any relation between the length of the list (n) and the length of the step (k)? Indeed there is such a
 * relation and often you can see sources directly saying that the best length k = √n. Why is that?
 * <p/>
 * Well, in the worst case, we do n/k jumps and if the last checked value is greater than the desired one,
 * we do at most k-1 comparisons more. This means n/k + k – 1 comparisons. Now the question is for what values of k
 * this function reaches its minimum. For those of you who remember maths classes this can be found with the formula
 * -n/(k^2) + 1 = 0. Now it’s clear that for k = √n the minimum of the function is reached.
 * <p/>
 * Of course you don’t need to prove this every time you use this algorithm. Instead you can directly assign √n to be
 * the step length. However it is good to be familiar with this approach when trying to optimize an algorithm.
 * <p/>
 * Let’s cosider the following list: (0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377,
 * 610). Its length is 16. Jump search will find the value of 55 with the following steps.
 *
 *    ___step 1__ ___step 2___ _____step 3_____
 *   |           |            |                |
 *   0  1  1  2  3  5  8  13  21  34  55  89  144
 *                            | s | s | res    |
 *                            |                |
 *                             -----back step--
 *
 *
 *
 * Complexity : O(√n)
 *
 * Application: When data is very large and divide it in half and then jumping back is costly
 *              Jump Search will be better choice
 *
 */
public class JumpSearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};


        System.out.printf("Search result is %2d\n", jumpSearch(arr, 1));
        System.out.printf("Search result is %2d\n", jumpSearch(arr, 2));
        System.out.printf("Search result is %2d\n", jumpSearch(arr, 3));
        System.out.printf("Search result is %2d\n", jumpSearch(arr, 4));
        System.out.printf("Search result is %2d\n", jumpSearch(arr, 5));
        System.out.printf("Search result is %2d\n", jumpSearch(arr, 6));
        System.out.printf("Search result is %2d\n", jumpSearch(arr, 7));
        System.out.printf("Search result is %2d\n", jumpSearch(arr, 8));
        System.out.printf("Search result is %2d\n", jumpSearch(arr, 9));

        System.out.printf("Search result is %2d\n", jumpSearch(arr, 10));
        System.out.printf("Search result is %2d\n", jumpSearch(arr, -10));
        System.out.printf("Search result is %2d\n", jumpSearch(arr, 100));


    }

    private static int jumpSearch(int[] array, int key) {

        int len = array.length;
        int unitStep = (int) Math.sqrt(len);
        int step = 0;
        int prev = 0;

        // jump forward
        while (array[step] < key) {
            prev = step;
            step = step + unitStep;

            // trivial condition search key is not exists
            // and in case of having high value than
            // the high in the search space
            if (step >= len) {
                return -1;
            }

        }

        // search in unit increment
        while (array[prev] < key) {
            prev++;
        }

        // reached the guessed position
        if (array[prev] == key) {
            return prev;
        }

        return -1;
    }

}
