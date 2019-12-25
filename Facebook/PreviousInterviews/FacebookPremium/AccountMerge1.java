package Facebook.PreviousInterviews.FacebookPremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AccountMerge1
{
    public static void main(String args[])
    {
        List<List<String>> accounts = new ArrayList<List<String>>()
        {{
            add(Arrays.asList("David","David0@m.co","David4@m.co","David3@m.co"));
            add(Arrays.asList("David","David5@m.co","David5@m.co","David0@m.co"));
            add(Arrays.asList("David","David1@m.co","David4@m.co","David0@m.co"));
            add(Arrays.asList("David","David0@m.co","David1@m.co","David3@m.co"));
            add(Arrays.asList("David","David0@m.co","David1@m.co","David3@m.co"));
        }};

        AccountMerge1 a = new AccountMerge1();
        List<List<String>> res = a.accountsMerge(accounts);
        for (List<String> r : res) {
            System.out.println(r);
        }
    }

    private List<List<String>> accountsMerge(List<List<String>> accounts)
    {
        List<List<String>> res = new ArrayList<>();
        if(accounts == null || accounts.size() == 0){
            return res;
        }

        Map<String, String> parent = new HashMap<>();
        Map<String, String> owner = new HashMap<>();
        Map<String, TreeSet<String>> union = new HashMap<>();

        for(List<String> account : accounts){
            if(account == null || account.size() == 0) continue;
            for(int i = 1; i < account.size(); i++){
                parent.put(account.get(i), account.get(i));
                owner.put(account.get(i), account.get(0));
            }
        }

        for(List<String> account : accounts){
            String p = find(account.get(1), parent);
            for(int i = 2; i < account.size(); i++){
                String k = find(account.get(i), parent);
                parent.put(k, p);
            }
        }

        for(List<String> account : accounts){
            String key = find(account.get(1), parent);
            if(!union.containsKey(key)){
                union.put(key, new TreeSet<>());
            }
            for(int i = 1; i < account.size(); i++){
                union.get(key).add(account.get(i));
            }
        }

        for(String key : union.keySet()){
            List<String> emails = new ArrayList<>(union.get(key));
            emails.add(0, owner.get(emails.get(0)));
            res.add(emails);
        }

        return res;
    }

    private String find(String s, Map<String, String> parent)
    {
        return parent.get(s) == s ? s : find(parent.get(s), parent);
    }
}
