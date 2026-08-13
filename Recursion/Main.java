public class Main {

    // helper method to create indentation for visual tracing
    private static void printIndent(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("│   ");
        }
    }

    // Custom helper method to print 1D arrays without libraries
    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : " "));
        }
        System.out.println("]");
    }

    // =========================================================
    // Lab Activity 1: Basic Recursion
    // =========================================================
    public static class BasicRecursion {

        // Exercise 1: Factorial with Tracing
        public static int factorial(int n, int depth) {
            printIndent(depth);
            if (n <= 1) {
                System.out.println("-> factorial(" + n + ") [Base Case]: Return 1");
                return 1;
            }
            System.out.println("-> factorial(" + n + "): Call " + n + " * factorial(" + (n - 1) + ")");
            int result = n * factorial(n - 1, depth + 1);
            printIndent(depth);
            System.out.println("<- [Return factorial(" + n + ")]: " + n + " * " + (result / n) + " = " + result);
            return result;
        }

        // Exercise 2: Sum of first n numbers with Tracing
        public static int sumN(int n, int depth) {
            printIndent(depth);
            if (n <= 0) {
                System.out.println("-> sumN(" + n + ") [Base Case]: Return 0");
                return 0;
            }
            System.out.println("-> sumN(" + n + "): Call " + n + " + sumN(" + (n - 1) + ")");
            int result = n + sumN(n - 1, depth + 1);
            printIndent(depth);
            System.out.println("<- [Return sumN(" + n + ")]: " + n + " + " + (result - n) + " = " + result);
            return result;
        }
    }

    // =========================================================
    // Lab Activity 2: Linear Recursion (Array Sum & Reverse)
    // =========================================================
    public static class LinearRecursion {

        // Exercise 1: Array Sum using Linear Recursion with Tracing
        public static int arraySum(int[] arr, int n, int depth) {
            printIndent(depth);
            if (n <= 0) {
                System.out.println("-> arraySum(n=" + n + ") [Base Case]: Return 0");
                return 0;
            }
            System.out.println("-> arraySum(n=" + n + "): Call arr[" + (n - 1) + "] (" + arr[n - 1] + ") + arraySum(n=" + (n - 1) + ")");
            int subSum = arraySum(arr, n - 1, depth + 1);
            int total = arr[n - 1] + subSum;
            printIndent(depth);
            System.out.println("<- [Return arraySum(n=" + n + ")]: " + arr[n - 1] + " + " + subSum + " = " + total);
            return total;
        }

        // Exercise 2: Reverse Array Recursively with Tracing
        public static void reverseArray(int[] arr, int start, int end, int depth) {
            printIndent(depth);
            if (start >= end) {
                System.out.println("-> reverse(start=" + start + ", end=" + end + ") [Base Case]: Reached center, stop.");
                return;
            }
            System.out.println("-> reverse(start=" + start + ", end=" + end + "): Swap arr[" + start + "](" + arr[start] + ") with arr[" + end + "](" + arr[end] + ")");
            
            // Swap elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Recursive Call
            reverseArray(arr, start + 1, end - 1, depth + 1);

            printIndent(depth);
            System.out.println("<- [Done reverse(start=" + start + ", end=" + end + ")]");
        }
    }
    // =========================================================
    // Lab Activity 3: Recursive Binary Search
    // =========================================================
    public static class BinarySearch {

        // Exercise 1: Recursive Binary Search with Tracing
        public static int searchRecursive(int[] arr, int target, int low, int high, int depth) {
            printIndent(depth);
            if (low > high) {
                System.out.println("-> search(low=" + low + ", high=" + high + ") [Base Case]: Target not found, return -1");
                return -1;
            }

            int mid = (low + high) / 2;
            System.out.println("-> search(low=" + low + ", high=" + high + "): mid=" + mid + " (val=" + arr[mid] + ")");

            if (arr[mid] == target) {
                printIndent(depth);
                System.out.println("<- [Found Target " + target + " at Index " + mid + "]");
                return mid;
            } else if (arr[mid] > target) {
                printIndent(depth);
                System.out.println("   Target " + target + " < " + arr[mid] + " -> Search Left Half");
                return searchRecursive(arr, target, low, mid - 1, depth + 1);
            } else {
                printIndent(depth);
                System.out.println("   Target " + target + " > " + arr[mid] + " -> Search Right Half");
                return searchRecursive(arr, target, mid + 1, high, depth + 1);
            }
        }

        // Exercise 2: Iterative Binary Search (For Comparison)
        public static int searchIterative(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == target) return mid;
                if (arr[mid] < target) low = mid + 1;
                else high = mid - 1;
            }
            return -1;
        }
    }

    // =========================================================
    // Lab Activity 4: Fibonacci Series using Recursion
    // =========================================================
    public static class FibonacciRecursion {

        // Exercise 1: Naive Recursive Fibonacci with Tracing
        public static int fibonacci(int n, int depth) {
            printIndent(depth);
            if (n <= 0) {
                System.out.println("-> fib(" + n + ") [Base Case]: Return 0");
                return 0;
            }
            if (n == 1) {
                System.out.println("-> fib(" + n + ") [Base Case]: Return 1");
                return 1;
            }

            System.out.println("-> fib(" + n + "): Branch into fib(" + (n - 1) + ") + fib(" + (n - 2) + ")");

            int f1 = fibonacci(n - 1, depth + 1);
            int f2 = fibonacci(n - 2, depth + 1);

            int result = f1 + f2;
            printIndent(depth);
            System.out.println("<- [Return fib(" + n + ")]: " + f1 + " + " + f2 + " = " + result);
            return result;
        }
    }

    // =========================================================
    // Main Method Execution
    // =========================================================
    public static void main(String[] args) {

        // --- LAB ACTIVITY 1 ---
        System.out.println("==================================================");
        System.out.println("=== LAB 1: BASIC RECURSION TRACING             ===");
        System.out.println("==================================================");
        System.out.println("\n1. Factorial of 4:");
        BasicRecursion.factorial(4, 0);

        System.out.println("\n2. Sum of first 5 natural numbers:");
        BasicRecursion.sumN(5, 0);

        // --- LAB ACTIVITY 2 ---
        System.out.println("\n==================================================");
        System.out.println("=== LAB 2: LINEAR RECURSION TRACING            ===");
        System.out.println("==================================================");
        int[] arr1 = {5, 10, 15, 20};
        System.out.print("\n1. Array Sum for ");
        printArray(arr1);
        LinearRecursion.arraySum(arr1, arr1.length, 0);

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.print("\n2. Reverse Array ");
        printArray(arr2);
        LinearRecursion.reverseArray(arr2, 0, arr2.length - 1, 0);
        System.out.print("   Reversed Result: ");
        printArray(arr2);

        // --- LAB ACTIVITY 3 ---
        System.out.println("\n==================================================");
        System.out.println("=== LAB 3: RECURSIVE BINARY SEARCH TRACING     ===");
        System.out.println("==================================================");
        int[] sortedArr = {11, 22, 33, 44, 55, 66, 77};
        int target = 55;
        System.out.print("Sorted Array: ");
        printArray(sortedArr);
        System.out.println("Searching for Target: " + target);
        BinarySearch.searchRecursive(sortedArr, target, 0, sortedArr.length - 1, 0);

        // --- LAB ACTIVITY 4 ---
        System.out.println("\n==================================================");
        System.out.println("=== LAB 4: FIBONACCI RECURSION TRACING         ===");
        System.out.println("==================================================");
        int fibN = 4;
        System.out.println("Computing Fibonacci(" + fibN + "):");
        FibonacciRecursion.fibonacci(fibN, 0);
    }
}