import java.util.*;
public class rec6 {
    //Print contiguous subarrays using recursion
    public static void printAllConbinations(int idx, List<Integer> ls, int[] arr){
        if(idx >= arr.length) {
            System.out.println(ls.toString());
            return;
        }
        ls.add(arr[idx]);
        printAllConbinations(idx + 1, ls, arr);
        ls.remove(ls.size() - 1);
        printAllConbinations(idx + 1, ls, arr);
    }
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        int[] arr = {3,1,2};
        printAllConbinations(0, ls, arr);

    }
}
