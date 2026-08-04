import java.util.*;

public class rec9_Quick_Sort {
    // Recursive function to perform quicksort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find pivot index such that elements on left are smaller, right are larger
            int pivotIndex = partition(arr, low, high);

            // Recursively sort left and right subarrays
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition logic choosing the last element as pivot
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap elements at i and j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot at its correct sorted position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
