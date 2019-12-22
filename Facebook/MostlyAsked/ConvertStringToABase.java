
package Facebook.MostlyAsked;

public class ConvertStringToABase
{
    final static String CONVERTER = "0123456789ABCDEF";

    public String getConverter(int number, int base){

        if(number < base) return String.valueOf(CONVERTER.charAt(number));
        else{
            return getConverter(number/base, base) + CONVERTER.charAt(number % base);
        }
    }

    public static void main(String args[]){
        System.out.println(new ConvertStringToABase().getConverter(1453, 16));
    }
}
