
/**
 * the class for "Maman11 - mission 5"
 * 
 * @auther Ben Shua (ID: 315270140)
 */
public class Mission5 {
    /**
     * the main function for "Maman11 - mission 5"
     * 
     * @auther Ben Shua (ID: 315270140)
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = new int[] { 0 };
        for (int i = 0; i < arr.length; i++) {
            System.out.println("[" + (i) + "]:" + arr[i]);
        }
        System.out.println(findPoint(arr, 0, arr.length - 1));

    }

    /**
     * assumption: A is a sorted array with unique values, j >= i
     * 
     * defenition: searchPoint is a point where the value is equel to the index
     * (i = A[i])
     * 
     * efficiency:
     * O(log(n))
     * 
     * runtime complexities:
     * T(n) = T(n/2) + 5 // q calc + checks(all false / last one true) + return
     * (until reached all which the final one is 3/4 but its calculated in T(n/2))
     * T(1) = ? (3<?<4) // q calc + checks + return (3 for searchPoint, 4 for not)
     * 
     * @param A int[]
     * @param i startIndex
     * @param j endIndex
     * @return int (index of point)
     */
    public static int findPoint(int[] A, int i, int j) {
        int q = (i + j) / 2;
        if (A[q] == q)
            return q;

        if (i == j)
            return -1;

        if (A[q] > q)
            return findPoint(A, i, q);
        return findPoint(A, q + 1, j);

    }

}