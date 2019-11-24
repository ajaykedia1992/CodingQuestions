package Glider.io;

public class NewPasswordTODO
{
    public static void main(String args[]){
        String password = "dijee";
    }
    private static void newPassword(String password) {
        int[] characters = new int[26];
        for(char c : password.toCharArray()){
            ++characters[c - 'a'];
        }
        StringBuffer originalString = new StringBuffer(password);
        StringBuffer a = new StringBuffer("");
        StringBuffer b = new StringBuffer("");
        for(int i = 0 ; i < 26; i++){
            if(characters[i] != 0) {
                while (characters[i] != 0) {
                    char c = (char) (i + 'a');
                    int k = 0;
                    while (originalString.charAt(k) != c) {
                        char ch = originalString.charAt(k);
                        originalString.deleteCharAt(0);
                        a.append(ch);
                        k++;
                    }
                    b.append(originalString.charAt(k));
                    --characters[i];
                }
            }
        }
    }
}
