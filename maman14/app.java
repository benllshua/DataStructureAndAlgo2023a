package maman14;

import java.util.Scanner;

/**
 * the class for "Maman14"
 * 
 * @auther Ben Shua (ID: 315270140)
 */
public class app {

    /**
     * 1A)
     * "d-array heap" representation in a one-dimensional array:
     * The root is A[0]
     * Parent of the node at index i (except root node) is located at index (i-1)/d
     * Children of the node at index i are at indices (d*i)+1 , (d*i)+2 …. (d*i)+d
     * (A[0] children are A[1] to A[d+1])
     * (Left-Child of A[i] is A[(d*i)+1])
     * (Right-Child of A[i] is A[(d*i)+d])
     * The last non-leaf node of a heap of size n is located at index (n-2)/d
     * 
     */

    /**
     * the main function for "Maman14"
     * 
     * @param args
     */

    private static int d;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Boolean closeSoftware = false;
        // main program loop
        while (!closeSoftware) {
            // basic config
            System.out.println("D ary Heap Test\n\n");
            System.out.print("d = ");
            int newD = scan.nextInt();
            while (newD <= 2) { // d > 2
                System.out.println("JOB FAILD: invalid D");
                System.out.print("d = ");
                newD = scan.nextInt();
            }
            scan.nextLine();
            d = newD;
            System.out.println("enter values with space between each value");
            String input = scan.nextLine();
            String[] inputs = input.split("\\s+");
            int[] values = new int[inputs.length];
            try {
                for (int i = 0; i < values.length; i++) {
                    values[i] = Integer.parseInt(inputs[i]);
                }

            } catch (Exception e) {
                System.out.println("JOB FAILD: one or more values are invalid");
            }
            int[] S = new int[values.length];
            buildHeap(S, d, values);
            Boolean reset = false;
            // menu loop, in some cases need to go back to the config...
            // hense the "reset" bool
            /** Perform D-ary Heap operations **/
            while (!reset) {

                System.out.println("\nD-ary Heap Operations\n");
                System.out.println("1. BUILD-HEAP (create heap from new d & values)");
                System.out.println("2. INSERT (insert value to the heap)");
                System.out.println("3. EXTRACT-MAX (extract the max value from the heap)");
                System.out.println("4. PRINT-HEAP (prints the heap)");
                System.out.println("5. CHANGE-d (changes the d and updates the heap)");
                System.out.println("(0 to close system)");
                System.out.print("> ");

                int choice = scan.nextInt();
                scan.nextLine();
                switch (choice) {
                    case 0:
                        reset = true;
                        closeSoftware = true;
                        break;
                    case 1:
                        reset = true; // go back to config new d & values
                        break;
                    case 2:
                        if (S != null) { // insert a new val using the insert method
                            System.out.print("value = ");
                            int val = scan.nextInt();
                            scan.nextLine();
                            insert(S, val);
                        }
                        break;
                    case 3:
                        if (S != null) {

                        }
                        break;
                    case 4:
                        // DO NOTHING, allready printing the array at the end of each menu cycle...
                        break;
                    case 5:
                        if (S != null) {
                            System.out.print("(new) d = ");
                            int val = scan.nextInt();
                            while (val <= 2) { // d > 2
                                System.out.println("JOB FAILD: invalid D");
                                System.out.print("d = ");
                                val = scan.nextInt();
                            }
                            scan.nextLine();
                            changeDValue(S, val);
                        }
                        break;
                    default:
                        System.out.println("Wrong Entry \n ");
                        break;
                }

                /** Display heap if not closing **/
                if (!reset) {
                    if (S == null) {
                        System.out.println("invalid heap");
                    } else {
                        printHeap(S);
                    }
                }
            }
        }

        scan.close();
    }

    /**
     * 
     * 
     * @param S int[] array to be filled with values
     * @param d the D in the DHeap param
     * @param L int[] values
     */
    public static void buildHeap(int[] S, int d, int[] L) {
        DArrayHeap dHeap = new DArrayHeap(L, d);
        int[] sortedValues = dHeap.getHeap();
        for (int i = 0; i < sortedValues.length; i++) {
            S[i] = sortedValues[i];
        }
    }

    public static void insert(int[] S, int x) {
        int[] values = new int[S.length + 1];
        for (int i = 0; i < values.length - 1; i++) {
            values[i] = S[i];
        }
        values[values.length - 1] = x;
        DArrayHeap dHeap = new DArrayHeap(values, d);
        int[] sortedValues = dHeap.getHeap();
        for (int i = 0; i < sortedValues.length; i++) {
            S[i] = sortedValues[i];
        }
    }

    public static void changeDValue(int[] S, int newD) {
        d = newD;
        DArrayHeap dHeap = new DArrayHeap(S, newD);
        int[] sortedValues = dHeap.getHeap();
        for (int i = 0; i < sortedValues.length; i++) {
            S[i] = sortedValues[i];
        }
    }

    public static void printHeap(int[] S) {
        DArrayHeap dHeap = new DArrayHeap(S, d);
        System.out.println(dHeap);
    }
}
