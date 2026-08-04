import java.util.*;

public class rec10_Combination_Sum_I {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinationSum(0, candidates, target, ans , new ArrayList<>());
        return ans;
    }
    private void findCombinationSum(int idx, int[] candidates, int target, List<List<Integer>> ans, List<Integer> arrayList) {
        if(idx == candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(arrayList));
                return;
            }
            return;
        }
        if (candidates[idx]<=target) {
            arrayList.add(candidates[idx]);
            findCombinationSum(idx, candidates, target-candidates[idx], ans, arrayList);
            arrayList.remove(arrayList.size()-1);
        }
        findCombinationSum(idx+1, candidates, target, ans, arrayList);
    }
    public static void main(String[] args) {
        rec10_Combination_Sum_I rec =new rec10_Combination_Sum_I();
        List<List<Integer>> ans = rec.combinationSum(new int[]{2,3,6,7}, 7);
        for (List<Integer> list : ans) {
            System.out.println(list.toString());
        }
    }
}
