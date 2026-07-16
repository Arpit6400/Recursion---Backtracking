import java.util.*;

public class rec11 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> set = new HashSet<>();
        findCombinationSum(0, candidates, target, set , new ArrayList<>());
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> list : set) {
            ans.add(list);
        }
        return ans;
    }
    private void findCombinationSum(int idx, int[] candidates, int target, HashSet<List<Integer>> set, List<Integer> arrayList) {
        if(idx == candidates.length){
            if(target==0){
                List<Integer> ans = new ArrayList<>(arrayList);
                Collections.sort(ans);
                set.add(ans);
            }
            return;
        }
        if (candidates[idx]<=target) {
            arrayList.add(candidates[idx]);
            findCombinationSum(idx+1, candidates, target-candidates[idx], set, arrayList);
            arrayList.remove(arrayList.size()-1);
        }
        findCombinationSum(idx+1, candidates, target, set, arrayList);
    }
    public static void main(String[] args) {
        
    }
}
