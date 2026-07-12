import java.util.ArrayList;
import java.util.List;

public class rec7 {
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
        List<Integer> ls = new ArrayList<>();
        int[] arr = {1,2,1};
        printSubsequenceWhereSumIsK(0, ls, arr, 0, 3);
    }
}
