import java.util.*;

class rec12_Subset_Sums {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        findSubsetSums(arr, 0, 0,  ans, new ArrayList<>());
        return ans;

    }

    private void findSubsetSums(int[] arr, int sum, int idx,  ArrayList<Integer> ans, ArrayList<Integer> arrayList) {
        if(idx>=arr.length){
            ans.add(sum);
            return;
        }
        arrayList.add(arr[idx]);
        sum+=arr[idx];
        findSubsetSums(arr, sum, idx+1, ans, arrayList);
        sum-=arr[idx];
        arrayList.remove(arrayList.size() -1);
        findSubsetSums(arr, sum, idx+1, ans, arrayList);
    }

    public static void main(String[] args) {

    }
}