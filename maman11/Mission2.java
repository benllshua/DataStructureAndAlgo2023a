import java.util.Arrays;

/**
 * the class for "Maman11 - mission 2"
 * 
 * @auther Ben Shua (ID: 315270140)
 */
public class Mission2 {
    /**
     * the main function for "Maman11 - mission 2"
     * 
     * @auther Ben Shua (ID: 315270140)
     * @param args
     */
    public static void main(String[] args) {
        int[] s = { 1, 2, 3, 4, -5 };

        System.out.println(maxDiff(s));
    }

    /**
     * efficiency:
     * O(n)
     * 
     * runtime complexities:
     * worst case: T(n) = 3 + 3n+1 // all numbers break new min / max record
     * (first number breaks both records hense the +1)
     * avg case: T(n) = 3 + ?n+1 (2<?<3) // some numbers break records (again first
     * number breaks both records hense the +1)
     * best case: T(n) = 3 + 2n+1 // all numbers are Integer.MAX_VALUE or
     * Integer.MIN_VALUE
     * 
     * @param arr int[]
     * @return int (max diff between 2 numbers)
     * 
     */
    public static int maxDiff(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        return max - min;
    }

    /**
     * Notes:
     * first I found a solution without sorting the array but it came up to O(n**2)
     * so I went with sorting first to reduce the complexity to O(n*log(n))
     * 
     * 
     * efficiency:
     * O(N*log(N))
     * 
     * runtime complexities:
     * worst case: T(n) = n*log(n) + 3 + 2n // all pairs break diff record
     * avg case: T(n) = n*log(n) + 3 + ?n // some broke diff record, some did not
     * best case: T(n) = n*log(n) + 3 + n+1 // all numbers are the same (first
     * compare sets diff to 0 (+1))
     * 
     * @param arr int[]
     * @return int (min diff between 2 numbers)
     * 
     */
    public static int minDiff(int[] arr) {
        // Sort array in non-decreasing order
        Arrays.sort(arr);

        // Initialize difference as infinite
        int diff = Integer.MAX_VALUE;

        // Find the min diff by comparing adjacent
        // pairs in sorted array
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i + 1] - arr[i] < diff)
                diff = arr[i + 1] - arr[i];

        // Return min diff
        return diff;
    }

}