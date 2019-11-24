package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainVisit
{
    public List<String> subdomainVisits(String[] cpdomains)
    {
        List<String> result = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            String[] splitString = s.split(" ");
            int count = Integer.parseInt(splitString[0]);
            StringBuilder domain = new StringBuilder(splitString[1]);
            checkMap(map, domain.toString(), count);
            while (domain.length() > 0) {
                int index = domain.indexOf(".");
                if (index == -1) {
                    break;
                }
                domain = new StringBuilder(domain.substring(index + 1, domain.length()));
                if (domain.length() > 0) {
                    checkMap(map, domain.toString(), count);
                }
            }
           /* if (domain.length() > 0) {
                checkMap(map, domain.toString(), count);
            }*/
        }


        for (Map.Entry m : map.entrySet()) {
            String s =  m.getValue() + " " + m.getKey();
            result.add(s);
        }
        return result;
    }

    public void checkMap(Map<String, Integer> map, String s, int count)
    {
        int c = 0;
        if (map.containsKey(s)) {
            c = map.get(s);
        }
        map.put(s, count + c);
    }

    public static void main(String args[]){
        String domains[] = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        SubDomainVisit s = new SubDomainVisit();
        System.out.println(s.subdomainVisits(domains));
    }
}
