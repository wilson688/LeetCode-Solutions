package strings;

import java.util.HashSet;
import java.util.Set;

class NumUniqueEmails {
    public int solution(String[] emails) {

        Set<String> seen = new HashSet();
        for(String email: emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i);
            String rest = email.substring(i);
            if(local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            local = local.replaceAll("\\.", "");
            seen.add(local+rest);
        }
        return seen.size();
    }

    public static void main(String args[]) {
        NumUniqueEmails obj = new NumUniqueEmails();
        System.out.println("===================");
        System.out.println(obj.solution(new String[]{"test.email+alex@leetcode.com", "test.email@leetcode.com"}));
    }
}