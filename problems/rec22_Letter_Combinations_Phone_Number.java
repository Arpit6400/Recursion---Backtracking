import java.util.*;

public class rec22_Letter_Combinations_Phone_Number {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        findCombinations(digits, 0, digits.length(), sb, map, ans);
        return ans;
    }
    private void findCombinations(String digits,int idx, int n, StringBuilder sb, String[] map, List<String> ans) {
       if (idx == n) {
            ans.add(sb.toString());
        return;
       }
        String sub = map[digits.charAt(idx) - '2'];
        for (int j = 0; j < sub.length(); j++) {
        sb.append(sub.charAt(j));
        findCombinations(digits,idx+1, n, sb, map, ans);
        sb.deleteCharAt(sb.length() -1);
       }
    }
    public static void main(String[] args) {
        rec22_Letter_Combinations_Phone_Number rec22_Letter_Combinations_Phone_Number = new rec22_Letter_Combinations_Phone_Number();
        List<String> finalAns = rec22_Letter_Combinations_Phone_Number.letterCombinations("23");
        for (String string : finalAns) {
            System.out.println(string);
        }
    }
}
