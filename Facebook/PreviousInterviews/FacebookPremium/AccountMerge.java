package Facebook.PreviousInterviews.FacebookPremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AccountMerge
{
    public static void main(String args[])
    {
        List<List<String>> accounts = new ArrayList<List<String>>()
        {{
            add(Arrays.asList("J", "a", "b", "c"));
            add(Arrays.asList("P", "d", "e", "f"));
            add(Arrays.asList("Q", "a", "d"));
        }};

        AccountMerge a = new AccountMerge();
        List<List<String>> res = a.accountsMerge(accounts);
        for (List<String> r : res) {
            System.out.println(r);
        }
    }

    private List<List<String>> accountsMerge(List<List<String>> accounts)
    {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> a : accounts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        for (List<String> a : accounts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++) {
                parents.put(find(a.get(i), parents), p);
            }
        }
        for (List<String> a : accounts) {
            String p = find(a.get(1), parents);
            if (!unions.containsKey(p)) {
                unions.put(p, new TreeSet<>());
            }
            for (int i = 1; i < a.size(); i++) {
                unions.get(p).add(a.get(i));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }

    private String find(String s, Map<String, String> p)
    {
        return p.get(s) == s ? s : find(p.get(s), p);
    }
}
