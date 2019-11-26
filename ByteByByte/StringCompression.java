package ByteByByte;

public class StringCompression
{
    public static void main(String args[]){
        String str = "aaabccc";
        StringCompression s = new StringCompression();
        String result = s.getStringCompression(str);
        System.out.println(result);
    }

    private String getStringCompression(String str)
    {
        if(str == null || str.length() == 0){
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = 1;
        for(int i = 0; i < str.length() - 1; i++){
            if(str.charAt(i) == str.charAt(i + 1)){
                size++;
            }else{
                stringBuilder.append(str.charAt(i)).append(size);
                size = 1;
            }

        }
        stringBuilder.append(str.charAt(str.length() - 1)).append(size);
        return stringBuilder.length() > str.length() ? str : stringBuilder.toString();
    }
}
