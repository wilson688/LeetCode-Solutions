package strings;

import java.util.Stack;

//leetcode question https://leetcode.com/problems/backspace-string-compare/submissions/

public class BackspaceCompare {
    //O(n) -> m + n

    public boolean solution_stack(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();



        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if(ch != '#') {
                stack1.push(ch); //abcd
            } else if(!stack1.isEmpty() && ch == '#'){
                stack1.pop(); //a
            }
        }

        for(int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);
            if(ch != '#') {
                stack2.push(ch); //bbcd
            } else if( !stack2.isEmpty() && ch == '#'){
                stack2.pop(); //a
            }
        }

        if(stack1.size() != stack2.size()) {
            return false;
        } else {
            if(stack1.isEmpty() && stack2.isEmpty() || stack1.equals(stack2)) {
                return true;
            } else
                return false;

        }
    }

    public boolean solution_loop(String S, String T) {

        if (S == null || S.length() == 0 || T == null || T.length() == 0) return true;


        String sFinal = removeBackspace(S);
        String tFinal = removeBackspace(T);

        return sFinal.equals(tFinal)? true : false;

    }

    private String removeBackspace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < s.length(); i++ ) { //
            if(i != 0 && s.charAt(i) == '#') {
                int getSbSize = sb.length() -1;  //2
                if(getSbSize >= 0) sb.deleteCharAt(getSbSize);

            } else if(s.charAt(i) != '#'){
                sb.append(s.charAt(i));
            }

        }
        return sb.toString();
    }
}
