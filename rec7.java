import java.util.ArrayList;
import java.util.List;

public class rec7 {
    public static int countSubsequenceWhereSumIsK(int idx, int[] arr, int sum, int targetSum){
        if (idx >=arr.length) {
            if(sum==targetSum) return 1;
            return 0;
        }
        sum+=arr[idx];
        int count1 = countSubsequenceWhereSumIsK(idx+1, arr, sum, targetSum);
        sum-=arr[idx];
        int count2 = countSubsequenceWhereSumIsK(idx+1, arr, sum, targetSum);
        return count1 + count2;
    }

    public static boolean printFirstSubsequenceWhereSumIsK(int idx, List<Integer> ls, int[] arr, int sum, int targetSum){
        if (idx >=arr.length) {
            if(sum==targetSum){
                System.out.println(ls.toString());
                return true;
            }
            return false;
        }
        ls.add(arr[idx]);
        sum+=arr[idx];
        if (printFirstSubsequenceWhereSumIsK(idx+1, ls, arr, sum, targetSum)) {
            return true;
        }
        ls.remove(ls.size() - 1);
        sum-=arr[idx];
        if (printFirstSubsequenceWhereSumIsK(idx+1, ls, arr, sum, targetSum)) {
            return true;
        }
        return false;
    }

    public static void printSubsequenceWhereSumIsK(int idx, List<Integer> ls, int[] arr, int sum, int targetSum){
        if (idx >=arr.length) {
            if(sum==targetSum){
                System.out.println(ls.toString());
                return;
            }
            return;
        }
        ls.add(arr[idx]);
        sum+=arr[idx];
        printSubsequenceWhereSumIsK(idx+1, ls, arr, sum, targetSum);
        ls.remove(ls.size() - 1);
        sum-=arr[idx];
        printSubsequenceWhereSumIsK(idx+1, ls, arr, sum, targetSum);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1,1};
        // printSubsequenceWhereSumIsK(0, ls, arr, 0, 3);
        // printFirstSubsequenceWhereSumIsK(0, ls, arr, 0, 2);
        System.out.println(countSubsequenceWhereSumIsK(0, arr, 0, 2));
    }
}
