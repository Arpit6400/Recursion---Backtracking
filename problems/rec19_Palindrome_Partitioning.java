import java.util.*;

public class rec19_Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        solvePartition(0, s, ans, path);
        return ans;
        
    }
    private void solvePartition(int idx, String s, List<List<String>> ans, List<String> path) {
       if(idx == s.length()){
        ans.add(new ArrayList<>(path));
        return;
       }
       for (int i = 0; i < s.length(); i++) {
        if (isPalindrome(s, idx, i)) {
            path.add(s.substring(idx, i+1));
            solvePartition(idx+1, s, ans, path);
            path.remove(path.size()-1);
        }
       }
    }
    private boolean isPalindrome(String s, int start, int end) {
        while (start<=end) {
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
