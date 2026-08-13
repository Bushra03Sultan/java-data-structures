public class Main {

    // helper method to create indentation for visual tracing tree
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
    // Lab Activity 1: Binary Sum with Tracing
    // =========================================================
    public static class BinarySum {

        public static int computeSumWithTrace(int[] arr, int start, int end, int depth) {
            printIndent(depth);

            // Base Case 1: Invalid range
            if (start > end) {
                System.out.println("-> sum(" + start + ", " + end + ") [Base Case]: Return 0");
                return 0;
            }

            // Base Case 2: Single element
            if (start == end) {
                System.out.println("-> sum(" + start + ", " + end + ") [Base Case]: Return arr[" + start + "] = " + arr[start]);
                return arr[start];
            }

            // Divide Step
            int mid = (start + end) / 2;
            System.out.println("-> sum(" + start + ", " + end + "): Split at mid=" + mid + " -> Left(" + start + ".." + mid + ") & Right(" + (mid + 1) + ".." + end + ")");

            // Conquer Step (Recursive Calls)
            int leftSum = computeSumWithTrace(arr, start, mid, depth + 1);
            int rightSum = computeSumWithTrace(arr, mid + 1, end, depth + 1);

            // Combine Step
            int total = leftSum + rightSum;
            printIndent(depth);
            System.out.println("<- [Return sum(" + start + ", " + end + ")]: " + leftSum + " + " + rightSum + " = " + total);

            return total;
        }
    }

    // =========================================================
    // Lab Activity 2: Fibonacci with Tracing
    // =========================================================
    public static class FibonacciCalculator {

        public static int fibonacciWithTrace(int n, int depth) {
            printIndent(depth);

            // Base Case 1: F(0) = 0
            if (n <= 0) {
                System.out.println("-> fib(" + n + ") [Base Case]: Return 0");
                return 0;
            }

            // Base Case 2: F(1) = 1
            if (n == 1) {
                System.out.println("-> fib(" + n + ") [Base Case]: Return 1");
                return 1;
            }

            // Divide / Recursive Branching
            System.out.println("-> fib(" + n + "): Call fib(" + (n - 1) + ") + fib(" + (n - 2) + ")");

            int fib1 = fibonacciWithTrace(n - 1, depth + 1);
            int fib2 = fibonacciWithTrace(n - 2, depth + 1);

            int result = fib1 + fib2;
            printIndent(depth);
            System.out.println("<- [Return fib(" + n + ")]: " + fib1 + " + " + fib2 + " = " + result);

            return result;
        }
    }

    // =========================================================
    // Main Method Execution
    // =========================================================
    public static void main(String[] args) {

        // -----------------------------------------------------
        // Demonstration 1: Binary Sum Tracing
        // -----------------------------------------------------
        System.out.println("==================================================");
        System.out.println("=== LAB 1: BINARY SUM EXECUTION TRACE         ===");
        System.out.println("==================================================");
        int[] numbers = {10, 20, 30, 40};
        
        System.out.print("Input Array: ");
        printArray(numbers);
        System.out.println("\n--- Starting Recursive Calls ---");
      int totalSum = BinarySum.computeSumWithTrace(numbers, 0, numbers.length - 1, 0);

        System.out.println("--------------------------------------------------");
        System.out.println("FINAL RESULT (Binary Sum) = " + totalSum);
        System.out.println("\n\n");

        // -----------------------------------------------------
        // Demonstration 2: Fibonacci Tracing
        // -----------------------------------------------------
        System.out.println("==================================================");
        System.out.println("=== LAB 2: FIBONACCI (n=4) EXECUTION TRACE    ===");
        System.out.println("==================================================");
        int targetFib = 4;
        
        System.out.println("Computing Fibonacci(" + targetFib + "):");
        System.out.println("\n--- Starting Recursive Calls ---");

        int fibResult = FibonacciCalculator.fibonacciWithTrace(targetFib, 0);

        System.out.println("--------------------------------------------------");
        System.out.println("FINAL RESULT (Fibonacci " + targetFib + ") = " + fibResult);
    }
}  