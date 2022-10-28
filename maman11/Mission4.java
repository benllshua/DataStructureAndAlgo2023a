/**
 * the class for "Maman11 - mission 4"
 * 
 * @auther Ben Shua (ID: 315270140)
 */
public class Mission4 {
    /**
     * the main function for "Maman11 - mission 4"
     * 
     * @auther Ben Shua (ID: 315270140)
     * @param args
     */

    public static void main(String[] args) {

        int[] A = new int[] { 1, 3, 2, 5, 10, 3, 7, 6, 1, 20, 21, 100, 19 };
        int[] B = new int[] { 2, 5, 7, 8, 13 };
        for (int i = 0; i < A.length; i++) {
            System.out.println("A[" + (i) + "]:" + A[i]);
        }
        for (int i = 0; i < B.length; i++) {
            System.out.println("B[" + (i) + "]:" + B[i]);
        }
        mergeSortWithInfo(A, B);
        for (int i = 0; i < A.length; i++) {
            System.out.println("A[" + (i) + "]:" + A[i]);
        }

    }

    public static void mergeSortWithInfo(int[] A, int[] B) {

        if (B.length == 0)
            return;

        int[] C = addElementToStart(B, 0);

        int[] sorted = new int[A.length];
        int[] indexes = new int[C.length];

        for (int i = 0; i < A.length; i++) {
            int curMin = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < C.length; j++) {

                if (C[j] + indexes[j] >= A.length)
                    continue;
                if (j != C.length - 1) {
                    if (C[j] + indexes[j] >= C[j + 1])
                        continue;
                }

                if (curMin > A[C[j] + indexes[j]]) {
                    curMin = A[C[j] + indexes[j]];
                    minIndex = j;
                }
            }
            sorted[i] = curMin;
            indexes[minIndex]++;
        }

        for (int i = 0; i < sorted.length; i++) {
            A[i] = sorted[i];
        }
    }

    public static int[] addElementToStart(int[] arr, int element) {
        int newArr[] = new int[arr.length + 1];
        newArr[0] = element;
        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }



}