import java.util.*;
import java.util.stream.Collectors;

public class rec14 {
    // public List<List<Integer>> permute(int[] nums) {
    //     List<List<Integer>> ans = new ArrayList<>();
    //     Boolean[] flag = new Boolean[nums.length];
    //     Arrays.fill(flag, false);
    //     permuteCombinations(nums, new ArrayList<>(), ans, flag);
    //     return ans;
    // }
    // private void permuteCombinations(int[] nums, List<Integer> arrayList, List<List<Integer>> ans, Boolean[] flag) {
    //     if(arrayList.size()==nums.length){
    //         ans.add(new ArrayList<>(arrayList));
    //         return;
    //     }
    //     for(int i = 0;i<nums.length;i++){
    //         if(!flag[i]){
    //             flag[i] = true;
    //             arrayList.add(nums[i]);
    //             permuteCombinations(nums, arrayList, ans, flag);
    //             flag[i]=false;
    //             arrayList.remove(arrayList.size() - 1);
    //         }
    //     }
    // }

    // Optimized Approach
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permuteCombinations(0, nums, ans);
        return ans;
    }
    
    private void permuteCombinations(int idx, int[] nums, List<List<Integer>> ans) {
        if (idx == nums.length) {
           ans.add(Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new)));
           return;
        }
        for(int i = idx;i<nums.length;i++){
            swap(nums, i, idx);
            permuteCombinations(idx+1, nums, ans);
            swap(nums, i, idx);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // private void permuteCombinations(int index, int[] nums, List<List<Integer>> ans) {
    //     if(index == nums.length) {
    //         List<Integer> temp = new ArrayList<>();
    //         for(int num : nums) {
    //             temp.add(num);
    //         }
    //         ans.add(temp);
    //         return;
    //     }
    //     for(int i = index; i < nums.length; i++) {
    //         swap(nums, i, index);
    //         permuteCombinations(index + 1, nums, ans);
    //         swap(nums, i, index);
    //     }
    // }
    // private void swap(int[] nums, int i, int j) {
    //     int temp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = temp;
    // }
    public static void main(String[] args) {
        
    }
}
