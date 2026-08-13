//بشرى فاروق نبيه سلطان
//446818050
//section:2385
public class SortingLab {

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;

        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];

        return result;
    }

    public static int[] quickSort(int[] arr) {
        if (arr.length <= 1) return arr;

        int pivot = arr[arr.length - 1];

        int lCount = 0, eCount = 0, gCount = 0;

        for (int num : arr) {
            if (num < pivot) lCount++;
            else if (num == pivot) eCount++;
            else gCount++;
        }

        int[] L = new int[lCount];
        int[] E = new int[eCount];
        int[] G = new int[gCount];

        int l = 0, e = 0, g = 0;

        for (int num : arr) {
            if (num < pivot) L[l++] = num;
            else if (num == pivot) E[e++] = num;
            else G[g++] = num;
        }

        L = quickSort(L);
        G = quickSort(G);

        int[] result = new int[arr.length];
        int idx = 0;

        for (int num : L) result[idx++] = num;
        for (int num : E) result[idx++] = num;
        for (int num : G) result[idx++] = num;

        return result;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        int[] mergeArr = {6, 3, 9, 5, 1};
        System.out.println("Act1 ");
        System.out.print("Merge Sort: ");
        printArray(mergeSort(mergeArr));

        int[] quickArr = {7, 2, 1, 6, 8, 5, 3, 4};
        System.out.println("Act2 ");
        System.out.print("Quick Sort: ");
        printArray(quickSort(quickArr));
    }
}
