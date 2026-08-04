import java.util.*;

public class rec23 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(0, n, sb, ans);
        return ans;
    }
    private void solve(int idx, int n, StringBuilder sb, List<String> ans) {
     if (idx == 2*n) {
        if (isValid(sb.toString())) {
            ans.add(sb.toString());
        }
        return;
     }
     sb.append('(');
     solve(idx+1, n, sb, ans);
     sb.deleteCharAt(sb.length()-1);
     sb.append(')');
     solve(idx+1, n, sb, ans);
     sb.deleteCharAt(sb.length() -1);
    }
    private boolean isValid(String str) {
        Stack<Character> stk = new Stack<>();
        for (Character ch : str.toCharArray()) {
            if(ch == ')' && !stk.isEmpty() && stk.peek() == '('){
                stk.pop();
            }
            else{
                stk.push(ch);
            }
        }
        return stk.isEmpty();
    }
    public static void main(String[] args) {
        rec23 rec23 = new rec23();
        List<String> ans = rec23.generateParenthesis(3);
        for (String string : ans) {
            System.out.println(string);
        }
    }
}
