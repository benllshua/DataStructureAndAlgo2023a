
/**
 * the class for "Maman11 - mission 1"
 * 
 * @auther Ben Shua (ID: 315270140)
 */
public class Mission1 {
    /**
     * the main function for "Maman11 - mission 1"
     * 
     * @auther Ben Shua (ID: 315270140)
     * @param args
     */
    public static void main(String[] args) {
        int[] s = new int[9];

        System.out.println(oddsSum(s));

    }

    /**
     * efficiency:
     * O(n)
     * 
     * runtime complexities:
     * worst case: T(n) = 2 + 2n // all odd numbers
     * avg case: T(n) = 2 + ?n (1<?<2) // some odd numbers
     * best case: T(n) = 2 + n // no odd numbers
     * 
     * @param A int[]
     * @return int (sum of all the odd numbers)
     */
    public static int oddsSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                sum += A[i];
            }
        }
        return sum;
    }

    /**
     * O(n)
     * 
     * runtime complexities:
     * 
     * T(n) = 2 + 2T(n/2)
     * T(1) = 3 // checks + return
     * 
     * 
     * @param A number array
     * @param p first index parameter
     * @param r second index parameter
     * @return int (sum of all the odd numbers between A[p] to A[r])
     */
    public static int SUM_ODD(int[] A, int p, int r) {
        return recursiveOddSum(A, p, r, 0);
    }

    public static int recursiveOddSum(int[] A, int p, int r, int sum) {
        if (r == p) {
            if (A[r] % 2 == 1)
                return sum + A[r];
            return sum;
        }

        int q = (r + p) / 2;
        return recursiveOddSum(A, p, q, sum) + recursiveOddSum(A, q + 1, r, sum);
    }

}