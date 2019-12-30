package Top50FacebookQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstBadVersion
{
    final static Set<Integer> BAD_VERSION = new HashSet<>(Arrays.asList(3, 4, 5));
    public static void main(String args[]){
        int n = 4;
        FirstBadVersion f = new FirstBadVersion();
        System.out.println(f.firstBadVersion(n));
    }
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        while(low < high){
            int mid = low + (high - low) / 2;
            if(isBadVersion(mid)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isBadVersion(int number)
    {
        return BAD_VERSION.contains(number);
    }
}
