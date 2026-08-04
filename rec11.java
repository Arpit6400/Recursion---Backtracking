import java.util.*;

public class rec11 {
    // Brute force approach
    // public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    //     HashSet<List<Integer>> set = new HashSet<>();
    //     Arrays.sort(candidates);
    //     findCombinationSum(0, candidates, target, set , new ArrayList<>());
    //     List<List<Integer>> ans = new ArrayList<>();
    //     for (List<Integer> list : set) {
    //         ans.add(list);
    //     }
    //     return ans;
    // }
    // private void findCombinationSum(int idx, int[] candidates, int target, HashSet<List<Integer>> set, List<Integer> arrayList) {
    //     if(idx == candidates.length){
    //         if(target==0){
    //             List<Integer> ans = new ArrayList<>(arrayList);
    //             Collections.sort(ans);
    //             set.add(ans);
    //         }
    //         return;
    //     }
    //     if (candidates[idx]<=target) {
    //         arrayList.add(candidates[idx]);
    //         findCombinationSum(idx+1, candidates, target-candidates[idx], set, arrayList);
    //         arrayList.remove(arrayList.size()-1);
    //     }
    //     findCombinationSum(idx+1, candidates, target, set, arrayList);
    // }
    
    // Optimal Approach
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCombinationSum(0, candidates, target, ans , new ArrayList<>());
        return ans;
    }
    private void findCombinationSum(int idx, int[] candidates, int target, List<List<Integer>> ans, List<Integer> arrayList) {
        if(target==0){
            ans.add(new ArrayList<>(arrayList));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if(i > idx && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;

            arrayList.add(candidates[i]);
            findCombinationSum(idx + 1, candidates, target - candidates[i], ans, arrayList);
            arrayList.remove(arrayList.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubsetsWithDup(0, nums, ans , new ArrayList<>());
        return ans;
    }
    private void findSubsetsWithDup(int idx, int[] nums, List<List<Integer>> ans, List<Integer> arrayList) {
        if(idx>=nums.length){
            ans.add(new ArrayList<>(arrayList));
            return;
        }
        for(int i = idx; i< nums.length;i++){
            if(i > idx && nums[i] == nums[i-1]) continue;

            arrayList.add(nums[i]);
            findSubsetsWithDup(i+1, nums, ans, arrayList);
            arrayList.remove(arrayList.size() - 1);
        }
    }
    public static void main(String[] args) {
        rec11 rec = new rec11();
        List<List<Integer>> ls = rec.combinationSum2(new int[]{2,1,1,1,2}, 4);
        for (List<Integer> list : ls) {
            System.out.println(list.toString());
        }
    }
}
