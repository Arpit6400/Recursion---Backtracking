import java.util.*;

public class rec4 { 
    public static void reverseArray(int left, int right, int arr[]){
        if(left >= right) return;
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        reverseArray(left + 1, right - 1, arr);
    }
    public static void reverseArrayUsingOneVeriable(int left, int arr[]){
        int n = arr.length;
        if(left >= n/2) return;
        int temp = arr[left];
        arr[left] = arr[n - left - 1];
        arr[n - left - 1] = temp;
        reverseArrayUsingOneVeriable(left + 1, arr);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        reverseArrayUsingOneVeriable(0, arr);
        System.out.println(Arrays.toString(arr));
    }
}