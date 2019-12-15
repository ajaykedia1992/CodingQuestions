package ByteByByte;

import java.util.ArrayList;

public class PermutationOfString
{
    public static void main(String args[]){
        String str = "abc";
        PermutationOfString permutationOfString = new PermutationOfString();
        ArrayList<String> result = permutationOfString.getPermutation(str);
        System.out.println(result);
    }

    private ArrayList<String> getPermutation(String str)
    {
        ArrayList<String> arrayList = new ArrayList<>();
        getPermutationUtil("", str, arrayList);
        return arrayList;
    }

    private void getPermutationUtil(String prefix, String suffix, ArrayList<String> arrayList)
    {
        if(suffix.length() == 0){
            arrayList.add(prefix);
        }
        else{
            for(int i = 0; i< suffix.length(); i++){
                getPermutationUtil(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1), arrayList);
            }
        }
    }
}
