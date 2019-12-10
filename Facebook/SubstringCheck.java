package Facebook;

public class SubstringCheck
{
    public static void main(String args[]){
        String parent = "abcedababteresbt";
        String child = "bat";

        boolean status = new SubstringCheck().isChildParent(parent, child);
        System.out.println(status);
    }

    private boolean isChildParent(String parent, String child)
    {
        if(parent == null || parent.length() == 0) return false;
        if(child == null || child.length() == 0) return true;
        if(child.length() > parent.length())  return false;

        int k = -1, j = 0;
        boolean flag = true;
        boolean isFound = false;
        for(int i = 0; i < parent.length(); i++){
            if(j < child.length() && parent.charAt(i) == child.charAt(j)){
                j++;
                if(flag) {
                    isFound = true;
                    k = i;
                }
                flag = false;
                continue;
            }

            if(child.length() == j){
                return true;
            }

            if(isFound){
                i = k;
                j = 0;
                isFound = false;
            }
            flag = true;
        }
        if(j == child.length()){
            return true;
        }
        return false;
    }
}
