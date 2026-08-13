public class Main {

    // ==========================================
    // 1. Matrix Operations Class
    // ==========================================
    public static class MatrixOps {

        // Matrix Addition
        public static int[][] add(int[][] A, int[][] B) {
            int rows = A.length;
            int cols = A[0].length;
            int[][] sum = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    sum[i][j] = A[i][j] + B[i][j];
                }
            }
            return sum;
        }

        // Matrix Multiplication
        public static int[][] multiply(int[][] A, int[][] B) {
            int rowsA = A.length;
            int colsA = A[0].length;
            int colsB = B[0].length;
            int[][] product = new int[rowsA][colsB];

            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    for (int k = 0; k < colsA; k++) {
                        product[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            return product;
        }

        // Custom method to print matrices without imports
        public static void printMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                System.out.print("[ ");
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println("]");
            }
        }
    }

    // ==========================================
    // 2. Array Rotation Class
    // ==========================================
    public static class ArrayRotation {

        public static int[] rotateLeft(int[] arr, int k) {
            int n = arr.length;
            k = k % n;
            int[] rotated = new int[n];
            for (int i = 0; i < n; i++) {
                rotated[i] = arr[(i + k) % n];
            }
            return rotated;
        }

        public static int[] rotateRight(int[] arr, int k) {
            int n = arr.length;
            k = k % n;
            int[] rotated = new int[n];
            for (int i = 0; i < n; i++) {
                rotated[(i + k) % n] = arr[i];
            }
            return rotated;
        }
    }

    // ==========================================
    // 3. Find Missing Number Class
    // ==========================================
    public static class MissingNumberFinder {

        public static int findMissing(int[] arr, int n) {
            int expectedSum = n * (n + 1) / 2;
            int actualSum = 0;
            for (int i = 0; i < arr.length; i++) {
                actualSum += arr[i];
            }
            return expectedSum - actualSum;
        }
    }

    // ==========================================
    // 4. Array Search and Sort Class
    // ==========================================
    public static class ArraySearchAndSort {

        // Linear Search
        public static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }

        // Insertion Sort
        public static void insertionSort(int[] arr) {
            int n = arr.length;
            for (int i = 1; i < n; i++) {
                int key = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;

                System.out.print("Iteration " + i + ": ");
                printArray(arr);
            }
        }
    }

    // Custom method to print 1D arrays without imports
    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
    // ==========================================
    // Main Method Execution
    // ==========================================
    public static void main(String[] args) {

        // --- 1. Matrix Operations ---
        System.out.println("=== 1. MATRIX OPERATIONS ===");
        
        // Matrix Addition Example
        int[][] A_add = { {1, 2, 3}, {4, 5, 6} };
        int[][] B_add = { {7, 8, 9}, {1, 2, 3} };
        System.out.println("Matrix A:");
        MatrixOps.printMatrix(A_add);
        System.out.println("Matrix B:");
        MatrixOps.printMatrix(B_add);
        System.out.println("Matrix Addition (A + B):");
        MatrixOps.printMatrix(MatrixOps.add(A_add, B_add));

        // Matrix Multiplication Example 
        int[][] A_mul = { {1, 2}, {3, 4} };
        int[][] B_mul = { {5, 6}, {7, 8} };
        System.out.println("\nMatrix Multiplication (A x B):");
        MatrixOps.printMatrix(MatrixOps.multiply(A_mul, B_mul));

        // --- 2. Array Rotation ---
        System.out.println("\n=== 2. ARRAY ROTATION ===");
        int[] arrToRotate = {1, 2, 3, 4, 5};
        System.out.print("Original Array: ");
        printArray(arrToRotate);

        System.out.print("Rotate Left (k=2): ");
        printArray(ArrayRotation.rotateLeft(arrToRotate, 2));

        System.out.print("Rotate Right (k=2): ");
        printArray(ArrayRotation.rotateRight(arrToRotate, 2));

        // --- 3. Find Missing Number ---
        System.out.println("\n=== 3. FIND MISSING NUMBER ===");
        int[] missingArr = {1, 2, 4, 5};
        int n = 5;
        System.out.print("Array: ");
        printArray(missingArr);
        System.out.println("Missing Number (n=" + n + "): " + MissingNumberFinder.findMissing(missingArr, n));

        // --- 4. Linear Search ---
        System.out.println("\n=== 4. LINEAR SEARCH ===");
        int[] searchArr = {1, 3, 5, 7};
        int target = 5;
        System.out.print("Array: ");
        printArray(searchArr);
        System.out.println("Target " + target + " at Index: " + ArraySearchAndSort.linearSearch(searchArr, target));

        // --- 5. Lab Activity: Insertion Sort ---
        System.out.println("\n=== LAB ACTIVITY: INSERTION SORT ===");
        int[] sortArr = {5, 3, 4, 1, 2};
        System.out.print("Initial Array: ");
        printArray(sortArr);

        ArraySearchAndSort.insertionSort(sortArr);

        System.out.print("Final Sorted Array: ");
        printArray(sortArr);
    }
}