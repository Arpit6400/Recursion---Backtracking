import java.util.*;

public class rec8_Merge_Sort {
    // Function to merge two sorted halves
    public static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;

        // Merge two sorted halves into temp list
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // Copy remaining elements of left half
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Copy remaining elements of right half
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Transfer sorted elements back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    // Recursive function to perform merge sort
    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;

        // Sort first and second halves
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        // Merge the sorted halves
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 7, 6, 3, 1, 5};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
